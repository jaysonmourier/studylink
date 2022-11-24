package com.devops.studylink.exceptions;

public class ResourceNotFoundException extends StudyLinkApiException {
    public ResourceNotFoundException() {
        super("Resource not found.");
    }
}
