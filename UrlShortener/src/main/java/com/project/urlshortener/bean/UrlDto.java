package com.project.urlshortener.bean;

import lombok.Data;

@Data
public class UrlDto {
    private String url;
    private String expirationDate;  //optional

    @Override
    public String toString() {
        return "UrlDto{" +
                "url='" + url + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                '}';
    }
}
