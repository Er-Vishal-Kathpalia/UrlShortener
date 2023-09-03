package com.project.urlshortener.bean;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UrlResponseDto {
    private String originalUrl;
    private String shortLink;
    private LocalDateTime expirationDate;

    @Override
    public String toString() {
        return "UrlResponseDto{" +
                "originalUrl='" + originalUrl + '\'' +
                ", shortLink='" + shortLink + '\'' +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
