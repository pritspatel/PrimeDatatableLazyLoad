package com.prits.backend.vo;

/**
 * Created by Pritesh Patel on 2/5/2017.
 */
public class SearchCriteria {

    private String _name;
    private String _value;

    public SearchCriteria() {
    }

    public SearchCriteria(String _name, String _value) {
        this._name = _name;
        this._value = _value;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_value() {
        return _value;
    }

    public void set_value(String _value) {
        this._value = _value;
    }

    @Override
    public String toString() {
        return "SearchCriteria{" +
                "_name='" + _name + '\'' +
                ", _value='" + _value + '\'' +
                '}';
    }
}
