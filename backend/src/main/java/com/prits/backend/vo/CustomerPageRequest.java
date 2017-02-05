package com.prits.backend.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pritesh Patel on 2/5/2017.
 */
public class CustomerPageRequest {

    private String _sortField;
    private String _sortOrder;
    private int _offSet;
    private int _size;
    private List<SearchCriteria> filters;

    public String get_sortField() {
        return _sortField;
    }

    public void set_sortField(String _sortField) {
        this._sortField = _sortField;
    }

    public String get_sortOrder() {
        return _sortOrder;
    }

    public void set_sortOrder(String _sortOrder) {
        this._sortOrder = _sortOrder;
    }

    public int get_offSet() {
        return _offSet;
    }

    public void set_offSet(int _offSet) {
        this._offSet = _offSet;
    }

    public int get_size() {
        return _size;
    }

    public void set_size(int _size) {
        this._size = _size;
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
                "_sortField='" + _sortField + '\'' +
                ", _sortOrder='" + _sortOrder + '\'' +
                ", _offSet=" + _offSet +
                ", _size=" + _size +
                ", filters=" + filters +
                '}';
    }
}
