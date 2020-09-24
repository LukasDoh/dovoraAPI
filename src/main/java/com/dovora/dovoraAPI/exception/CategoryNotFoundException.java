package com.dovora.dovoraAPI.exception;

/**
 * Exception if category is not found via id.
 */
public class CategoryNotFoundException extends Exception{

    private long category_id;

    public CategoryNotFoundException(long category_id) {
        super(String.format("Category is not found with id : '%s'", category_id));
    }
}
