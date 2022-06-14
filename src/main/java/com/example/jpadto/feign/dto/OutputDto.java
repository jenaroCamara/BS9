package com.example.jpadto.feign.dto;

public class OutputDto {
    int statusCode;
    String name;

    public OutputDto() {}

    public OutputDto(int statusCode, String name) {
        this.statusCode = statusCode;
        this.name = name;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

