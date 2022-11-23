package com.devops.studylink.exceptions;

public class DuplicateResourceException extends StudyLinkApiException {
    public DuplicateResourceException() {
        super("The resource already exists.");
    }
}
