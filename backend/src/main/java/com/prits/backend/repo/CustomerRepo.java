package com.prits.backend.repo;

import com.prits.backend.entity.Customer;
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
    public List<Customer> getAllCustomer(int offSet, int size, String sortField, String sortOrder){
        String sql = "select * from customer order by " + sortField + " " + sortOrder +  " limit " + offSet +"," + size;
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


}
