package com.prits.backend.entity;

/**
 * Created by 3ppat on 1/28/2017.
 */
public class Customer {

    private Integer customer_id;
    private String firstName;
    private String lastName;
    private String email;

    public Customer(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public Customer(Integer customer_id, String firstName, String lastName, String email) {
        this.customer_id = customer_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customer_id=" + customer_id +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
