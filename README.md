# UrlShortener
Url Shortener using spring boot


APIs to Run from Postmam
1. To Generate a shorten URL
```
curl --location 'http://localhost:9010/url/shortener/generate' \
--header 'Content-Type: application/json' \
--data '{
    "url": "https://leetcode.com/problemset/all/"
    
}'
```
2. To Redirect to the original URL
```
curl --location 'http://localhost:9010/url/shortener/{generatedHashValueInDB}'
``` 
