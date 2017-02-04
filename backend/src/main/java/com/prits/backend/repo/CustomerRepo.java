package com.prits.backend.repo;

import com.prits.backend.dto.Page;
import com.prits.backend.dto.PageRequest;
import com.prits.backend.dto.PaginationHelper;
import com.prits.backend.entity.Customer;
import com.prits.backend.mapper.CustomerRowMapper;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;

//import static org.jooq.impl.DSL.*;

/**
 * Created by Pritesh Patel on 1/28/2017.
 */
@Repository
public class CustomerRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(readOnly = true)
    public List<Customer> getAllCustomer(int offSet, int size, String sortField, String sortOrder,String filterField, String filterValue){
        //String sql = "select * from customer order by " + sortField + " " + sortOrder +  " limit " + offSet +"," + size;
        String sql = buildQuery(offSet, size, sortField, sortOrder, filterField, filterValue);
        System.out.println("******* Query : " + sql);
        List<Customer> customers = new ArrayList<Customer>();
        List<Map<String, Object>> rows = this.jdbcTemplate.queryForList(sql);
        for (Map row : rows) {
            Customer c = new Customer((Integer) row.get("CUSTOMER_ID"));
            c.setFirstName((String) row.get("first_name"));
            c.setLastName((String) row.get("last_name"));
            c.setEmail((String) row.get("email"));
            customers.add(c);
        }
       return customers;
    }

    @Transactional(readOnly = true)
    public int getTotalCount(){
        String sql = "select count(*) from customer";
        return this.jdbcTemplate.queryForObject(sql, Integer.class);

    }

    /**
     * Builds select query based on provided data
     * @param offSet
     * @param size
     * @param sortField
     * @param sortOrder
     * @param filterField
     * @param filterValue
     * @return
     */
    private String buildQuery(int offSet, int size, String sortField, String sortOrder,String filterField, String filterValue){
        SelectBuilder query = new SelectBuilder()
                .from("Customer")
                .column("*");
        if(filterField != null && !filterField.trim().equalsIgnoreCase("") && filterValue != null && !filterValue.trim().equalsIgnoreCase("")){
            query.where(filterField + " LIKE '%"+ filterValue.trim()+"%'");
        }
        if(sortField != null  && sortOrder != null){
            if(!sortOrder.equalsIgnoreCase("asc")) {
                query.orderBy(sortField + " " + sortOrder);
            }
        }
        String q = query.toString();
        q = q + " limit " + offSet +"," + size;
        return q;
    }

    /**
     * Builds record count query based on provided data
     * @param offSet
     * @param size
     * @param sortField
     * @param sortOrder
     * @param filterField
     * @param filterValue
     * @return
     */
    private String buildCountQuery(int offSet, int size, String sortField, String sortOrder,String filterField, String filterValue){
        SelectBuilder query = new SelectBuilder()
                .from("Customer")
                .column("count(*)");
        if(filterField != null && !filterField.trim().equalsIgnoreCase("") && filterValue != null && !filterValue.trim().equalsIgnoreCase("")){
            query.where(filterField + " LIKE '%"+ filterValue.trim()+"%'");
        }
       /* if(sortField != null  && sortOrder != null){
            query.orderBy(sortField + " " + sortOrder);
        }*/
       // String q = query.toString();
       // q = q + " limit " + offSet +"," + size;
        return query.toString();
    }

    public Page<Customer> getCustomers(int offSet, int size, String sortField, String sortOrder, String filterField, String filterValue){
        PaginationHelper helper = new PaginationHelper();
        String countQuery = buildCountQuery(offSet, size, sortField, sortOrder, filterField, filterValue);
        String actualQuery = buildQuery(offSet, size, sortField, sortOrder, filterField, filterValue);
        PageRequest request = new PageRequest(countQuery,actualQuery,offSet,size,null,new CustomerRowMapper());
        return (Page<Customer>) helper.fetchPage(this.jdbcTemplate,request);
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
