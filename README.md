# UrlShortener
Url Shortener using spring boot.
The Project created for the learning purpose.

Steps to RUN::
1. To Run this project clone the repo in your local.
2. Open the project on IDE for spring boot like intellij or Visual Studio code or Eclipse IDE.
3. Build and Run the project in local and hit the API's from Postman.


API CURLs to Run from Postmam
1. To Generate a shorten URL
```
curl --location 'http://localhost:9010/url/shortener/generate' \
--header 'Content-Type: application/json' \
--data '{
    "url": "https://leetcode.com/problemset/all/"
    
}'
```
Response:
<img width="1282" alt="image" src="https://github.com/Er-Vishal-Kathpalia/UrlShortener/assets/52442349/013808ec-0702-422f-9d2f-f1ac775820fa">

2. To Redirect to the original URL
```
curl --location 'http://localhost:9010/url/shortener/{generatedHashValue}'
```
Resonse: API will return the HTML. It is recommend to hit the URl from Browser.
<img width="1296" alt="image" src="https://github.com/Er-Vishal-Kathpalia/UrlShortener/assets/52442349/74e1d04a-ceee-473b-9d50-afae12547918">

<img width="1545" alt="image" src="https://github.com/Er-Vishal-Kathpalia/UrlShortener/assets/52442349/b7bfb81b-b556-4651-8b55-6c68384610b9">
