package com.project.urlshortener.bean;

import lombok.Data;

@Data
public class UrlErrorResponseDto {
    private String status;
    private String error;

    @Override
    public String toString() {
        return "UrlErrorResponseDto{" +
                "status='" + status + '\'' +
                ", error='" + error + '\'' +
                '}';
    }
}
