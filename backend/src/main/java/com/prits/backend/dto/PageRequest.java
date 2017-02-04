package com.prits.backend.dto;


import org.springframework.jdbc.core.RowMapper;

/**
 * Created by Pritesh Patel on 2/4/2017.
 */
public class PageRequest {

    private String countQuery;
    private String resultQuery;
    private int totalRows;
    private int offset;
    private Object[] args = new Object[]{};
    private RowMapper rowMapper;

    public PageRequest(String countQuery, String resultQuery, int offset, int totalRows, Object[] args, RowMapper rowMapper) {
        this.countQuery = countQuery;
        this.resultQuery = resultQuery;
        this.totalRows = totalRows;
        this.offset = offset;
        this.args = args;
        this.rowMapper = rowMapper;
    }

    public String getCountQuery() {
        return countQuery;
    }

    public void setCountQuery(String countQuery) {
        this.countQuery = countQuery;
    }

    public String getResultQuery() {
        return resultQuery;
    }

    public void setResultQuery(String resultQuery) {
        this.resultQuery = resultQuery;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    public RowMapper getRowMapper() {
        return rowMapper;
    }

    public void setRowMapper(RowMapper rowMapper) {
        this.rowMapper = rowMapper;
    }
}
