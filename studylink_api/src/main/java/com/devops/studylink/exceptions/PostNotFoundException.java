package com.devops.studylink.exceptions;

public class PostNotFoundException extends PostException {

    public PostNotFoundException() {
        super("Not Found.");
    }

}