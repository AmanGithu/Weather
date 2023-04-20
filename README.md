# Info

Rapid API does not offer an API that enables authentication and provides an API key for passing along with open APIs in order to obtain weather forecasts.

# Weather
#REST API

The REST API to the weather app is described below.

##Get weather summary

###Request

'Accept: application/json' 'client-secret: <Client Secret>' 'client-id: <Client Id>' http://localhost:8080/forecast/<city_name(Mumbai)>/summary
                                                                                                                                               
### Response

   Date: Thu, 20 Apr 2023 06:48:59 GMT
   Connection: keep-alive
   Content-Type: application/json
   Transfer-Encoding: chunked
   Keep-Alive: timeout-60

##Get weather hourly

###Request

'Accept: application/json' 'client-secret: <Client Secret>' 'client-id: <Client Id>' http://localhost:8080/forecast/<city_name(Mumbai)>/hourly
  
### Response

   Date: Thu, 20 Apr 2023 06:48:59 GMT
   Connection: keep-alive
   Content-Type: application/json
   Transfer-Encoding: chunked
   Keep-Alive: timeout-60
