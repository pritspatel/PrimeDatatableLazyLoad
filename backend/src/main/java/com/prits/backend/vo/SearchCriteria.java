package com.prits.backend.vo;

/**
 * Created by Pritesh Patel on 2/5/2017.
 */
public class SearchCriteria {

    private String name;
    private String value;

    public SearchCriteria() {
    }

    public SearchCriteria(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String _name) {
        this.name = _name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String _value) {
        this.value = _value;
    }

    @Override
    public String toString() {
        return "SearchCriteria{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
