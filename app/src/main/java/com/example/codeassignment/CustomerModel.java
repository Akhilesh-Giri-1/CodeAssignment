package com.example.codeassignment;

public class CustomerModel {

    private String customer_name;
    private String customer_address;

    public CustomerModel(String customer_name, String customer_address) {
        this.customer_name = customer_name;
        this.customer_address = customer_address;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

}

