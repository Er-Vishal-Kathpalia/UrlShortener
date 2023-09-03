package com.project.urlshortener.service;

import com.project.urlshortener.bean.Url;
import com.project.urlshortener.bean.UrlDto;
import org.springframework.stereotype.Service;

@Service
public interface UrlService {
    public Url generateShortLink(UrlDto urlDto);
    public Url persistShortLink(Url url);
    public Url getEncodedUrl(String url);
    public void deleteShortLink(Url url);
}
