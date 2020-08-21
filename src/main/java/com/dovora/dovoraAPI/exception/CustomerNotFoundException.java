package com.dovora.dovoraAPI.exception;

public class CustomerNotFoundException extends Exception {

    private long customer_id;

    public CustomerNotFoundException(long customer_id) {
        super(String.format("Customer is not found with id : '%s'", customer_id));
    }
}
