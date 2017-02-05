package com.prits.backend.vo;

import java.util.List;

/**
 * Created by Pritesh Patel on 2/5/2017.
 */
public class CustomerPageResponse {

    private int totalRows;
    private List<?> results;

    public CustomerPageResponse(int totalRows, List<?> results) {
        this.totalRows = totalRows;
        this.results = results;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public List<?> getResults() {
        return results;
    }

    public void setResults(List<?> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "CustomerPageResponse{" +
                "totalRows=" + totalRows +
                ", results=" + results +
                '}';
    }
}
