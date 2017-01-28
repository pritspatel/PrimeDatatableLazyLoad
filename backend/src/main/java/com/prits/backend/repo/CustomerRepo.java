package com.prits.backend.repo;

import com.prits.backend.entity.Customer;
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

/**
 * Created by Pritesh Patel on 1/28/2017.
 */
@Repository
public class CustomerRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(readOnly = true)
    public List<Customer> getAllCustomer(int offSet, int size){
        String sql = "select * from customer order by customer_id limit " + offSet +"," + size;
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
