package com.prits.backend.dto;

import com.prits.backend.entity.Customer;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Pritesh Patel on 2/4/2017.
 */
public class PaginationHelper {

    public Page<?> fetchPage(
            final JdbcTemplate jt,
            final PageRequest request) {

        // determine how many rows are available
        System.out.println("Running count query : " + request.getCountQuery());
        final int rowCount = jt.queryForObject(request.getCountQuery(), request.getArgs(), Integer.class);

        // calculate the number of pages
        int pageCount = rowCount / request.getTotalRows();
        if (rowCount > request.getTotalRows() * pageCount) {
            pageCount++;
        }

        // create the page object
        final Page<?> page = new Page();
        page.setPageNumber(request.getOffset());
        page.setPagesAvailable(pageCount);

        System.out.println("Running result query : " + request.getResultQuery());
        List<Customer> customers = new ArrayList<Customer>();
        List<Map<String, Object>> rows = jt.queryForList(request.getResultQuery());
        for (Map row : rows) {
            Customer c = new Customer((Integer) row.get("CUSTOMER_ID"));
            c.setFirstName((String) row.get("first_name"));
            c.setLastName((String) row.get("last_name"));
            c.setEmail((String) row.get("email"));
            customers.add(c);
        }
        page.setPageItems(customers);

        // fetch a single page of results
       /* final int startRow = (request.getOffset() - 1) * request.getTotalRows();
        jt.query(
                request.getResultQuery(),
                request.getArgs(),
                new ResultSetExtractor() {
                    public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
                        final List pageItems = page.getPageItems();
                        int currentRow = 0;
                        while (rs.next() && currentRow <startRow + pageSize) {
                            if (currentRow >= startRow) {
                                pageItems.add(rowMapper.mapRow(rs, currentRow));
                            }
                            currentRow++;
                        }
                        return page;
                    }
                });*/
        return page;
    }

}
