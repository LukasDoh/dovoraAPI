package com.dovora.dovoraAPI.exception;

/**
 * Exception if customer is not found via id.
 */
public class CustomerNotFoundException extends Exception {

    private long customer_id;

    public CustomerNotFoundException(long customer_id) {
        super(String.format("Customer is not found with id : '%s'", customer_id));
    }
}
