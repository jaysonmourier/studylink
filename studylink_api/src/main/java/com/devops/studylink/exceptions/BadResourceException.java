package com.devops.studylink.exceptions;

public class BadResourceException extends StudyLinkApiException {
    public BadResourceException() {
        super("Invalid content.");
    }
}
