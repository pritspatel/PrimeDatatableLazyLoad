package com.prits.backend.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pritesh Patel on 2/5/2017.
 */
public class CustomerPageRequest {

    private String sortField;
    private String sortOrder;
    private int offSet;
    private int size;
    private List<SearchCriteria> filters;

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String _sortField) {
        this.sortField = _sortField;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String _sortOrder) {
        this.sortOrder = _sortOrder;
    }

    public int getOffSet() {
        return offSet;
    }

    public void setOffSet(int _offSet) {
        this.offSet = _offSet;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int _size) {
        this.size = _size;
    }

    public List<SearchCriteria> getFilters() {
        if(this.filters == null){
            this.filters = new ArrayList<SearchCriteria>();
        }
        return filters;
    }

    public void setFilters(List<SearchCriteria> filters) {
        this.filters = filters;
    }

    @Override
    public String toString() {
        return "CustomerPageRequest{" +
                "sortField='" + sortField + '\'' +
                ", sortOrder='" + sortOrder + '\'' +
                ", offSet=" + offSet +
                ", size=" + size +
                ", filters=" + filters +
                '}';
    }
}
