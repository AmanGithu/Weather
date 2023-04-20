# Weather App

Rapid API does not provide an authentication API that allows users to obtain a weather forecast API key for authentication purposes. However, the only way to obtain an API key is through Rapid API's user interface portal.

# REST API

    The REST API to the weather app is described below.
    
    /forecast/{city_name}/{forecast_type} :
        city_name =  well-known cities such as Mumbai and Berlin
        forecast_type = summary / hourly.

## Get weather summary

### Request

`GET /forecast/{city_name}/{forecast_type}`

    'Accept: application/json' 'client-secret: <Client Secret>' 'client-id: <Client Id>' http://localhost:8080/forecast/Mumbai/summary
                                                                                                                                               
### Response

    Date: Thu, 20 Apr 2023 06:48:59 GMT
    Connection: keep-alive
    Content-Type: application/json
    Transfer-Encoding: chunked
    Keep-Alive: timeout-60

## Get weather hourly

### Request
`GET /forecast/{city_name}/{forecast_type}`

    'Accept: application/json' 'client-secret: <Client Secret>' 'client-id: <Client Id>' http://localhost:8080/forecast/Mumbai/hourly
  
### Response

    Date: Thu, 20 Apr 2023 06:48:59 GMT
    Connection: keep-alive
    Content-Type: application/json
    Transfer-Encoding: chunked
    Keep-Alive: timeout-60
