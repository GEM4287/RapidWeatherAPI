# RapidWeatherAPI

API Endpoints
API 1: Get Forecast Summary by Location Name.
This endpoint retrieves the weather forecast summary of any city.

Endpoint: /forecast/summary/{locationName}

HTTP Method: GET

Parameters: locationName (required): The name of the city for which you want to retrieve the forecast summary.

Example : 
GET /forecast/summary/London

API 2: Get Hourly Forecast by Location Name.
This endpoint retrieves hourly weather forecast details of any city.

Endpoint: /forecast/hourly/{locationName}

HTTP Method: GET

Parameters: locationName (required): The name of the city for which you want to retrieve the hourly forecast.

Example :
GET /forecast/hourly/London
