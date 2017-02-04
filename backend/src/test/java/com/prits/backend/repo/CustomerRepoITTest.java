package com.prits.backend.repo;

import com.prits.backend.dto.Page;
import com.prits.backend.entity.Customer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import java.util.List;

/**
 * Created by Pritesh Patel on 2/4/2017.
 */
public class CustomerRepoITTest {

    private EmbeddedDatabase db;

    private CustomerRepo dao;

    @Before
    public void setUp() {
        //db = new EmbeddedDatabaseBuilder().addDefaultScripts().build();
        db = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("sql/create-db.sql")
                .addScript("sql/insert-data.sql")
                .build();
    }

    @Test
    public void testFindByname() {
        JdbcTemplate template = new JdbcTemplate(db);
        dao = new CustomerRepo();
        dao.setJdbcTemplate(template);
        Page<Customer> customers = dao.getCustomers(10,10,"CUSTOMER_ID","ASC","","");
        Assert.assertNotNull(customers);
        System.out.println("********************* Results **************");
        System.out.println(customers.toString());
        List<Customer> cList = (List<Customer>) customers.getPageItems();
        for (Customer c : cList){
            Assert.assertTrue(c.getCustomer_id()==11);
            break;
        }
    }

    @After
    public void tearDown() {
        db.shutdown();
    }

}
