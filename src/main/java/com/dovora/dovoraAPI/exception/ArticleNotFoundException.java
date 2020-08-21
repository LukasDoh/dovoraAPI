package com.dovora.dovoraAPI.exception;

public class ArticleNotFoundException extends Exception {

    private long article_id;

    public ArticleNotFoundException(long article_id) {
        super(String.format("Article is not found with id : '%s'", article_id));
    }
}
