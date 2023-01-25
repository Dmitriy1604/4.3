package com.example.demo.exception;

public class FileIsTooBigException extends RuntimeException {
    private final long sizeLimit;

    public FileIsTooBigException(long sizeLimit) {
        this.sizeLimit = sizeLimit;
    }

    public long getSizeLimit() {
        return sizeLimit;
    }
}
