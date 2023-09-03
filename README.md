# UrlShortener
Url Shortener using spring boot.
The Project created for the learning purpose.

Steps to RUN::
1. To Run this project clone the repo in your local.
2. Open the project on IDE for spring boot like intellij or Visual Studio code or Eclipse IDE.
3. Build and Run the project in local and hit the API's from Postman.


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
