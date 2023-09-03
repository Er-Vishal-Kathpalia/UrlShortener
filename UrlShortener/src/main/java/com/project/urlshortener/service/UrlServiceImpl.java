package com.project.urlshortener.service;

import com.google.common.hash.Hashing;
import com.project.urlshortener.bean.UrlDto;
import com.project.urlshortener.repository.UrlRepository;
import com.project.urlshortener.bean.Url;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class UrlServiceImpl implements UrlService {

    private static final Logger logger = LoggerFactory.getLogger(UrlServiceImpl.class);
    private final UrlRepository urlRepository;

    @Override
    public Url generateShortLink( UrlDto urlDto) {

        if(StringUtils.isNotEmpty(urlDto.getUrl())) {
            String encodedUrl = encodeUrl(urlDto.getUrl());
            Url urlToPersist = new Url();
            urlToPersist.setCreationDate(LocalDateTime.now());
            urlToPersist.setOriginalUrl(urlDto.getUrl());
            urlToPersist.setShortLink(encodedUrl);
            urlToPersist.setExpirationDate(getExpirationDate(urlDto.getExpirationDate(),urlToPersist.getCreationDate()));
            Url urlToRet = persistShortLink(urlToPersist);

            if(urlToRet != null)
                return urlToRet;

            return null;
        }
        return null;
    }

    //if Expiration date is not provided then it will be 90 days by default
    private LocalDateTime getExpirationDate(String expirationDate, LocalDateTime creationDate) {
        if(StringUtils.isBlank(expirationDate))
        {
            return creationDate.plusDays(90);
        }
        LocalDateTime expirationDateToRet = LocalDateTime.parse(expirationDate);
        return expirationDateToRet;
    }

    private String encodeUrl(String url)
    {
        String encodedUrl = "";
        LocalDateTime time = LocalDateTime.now();
        encodedUrl = Hashing.murmur3_32()
                .hashString(url.concat(time.toString()), StandardCharsets.UTF_8)
                .toString();
        return  encodedUrl;
    }

    @Override
    public Url persistShortLink(Url url) {
        Url urlToRet = urlRepository.save(url); //BaseGlobal
        return urlToRet;
    }

    @Override
    public Url getEncodedUrl(String url) {
        System.out.println(url);
        Url urlToRet = urlRepository.findByShortLink(url);
        return urlToRet;
    }

    @Override
    public void deleteShortLink(Url url) {
        urlRepository.delete(url);
    }
}
