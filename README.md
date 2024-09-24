# Location REST API

This project is a REST API for managing locations: continents, countries, and cities.

## Prerequisites

- **Java**: JDK 17
- **Gradle**: Gradle is used for building the project.
- **Docker**: The application can be built and run using Docker.

## Building and Running the Project

### Local Development without Docker

**Build and run the project**:

   ./gradlew clean build bootRun

### Using Docker

1. **Build the Docker image**:

   docker-compose build

2. **Run the container**:

   docker-compose up

    API will be available at `http://localhost:8080`.

3. **Stop the container**:

   docker-compose down

## API Endpoints and Example Usage

### Continent Endpoints

- **POST** `/api/location/continent`: Create a new continent.

  Example:  
  curl -X POST http://localhost:8080/api/location/continent  
  -H "Content-Type: application/json"  
  -d '{  
  "continentName": "Europe"  
  }'

- **GET** `/api/location/get-continents`: Get all continents.

  Example:  
  curl -X GET http://localhost:8080/api/location/get-continents

- **GET** `/api/location/continent/{id}/get-countries`: Get all countries in a continent by continent ID.

  Example:  
  curl -X GET http://localhost:8080/api/location/continent/1/get-countries

- **PUT** `/api/location/continent/{id}`: Update an existing continent by ID.

  Example:  
  curl -X PUT http://localhost:8080/api/location/continent/1  
  -H "Content-Type: application/json"  
  -d '{  
  "continentName": "Updated Continent Name"  
  }'

- **DELETE** `/api/location/continent/{id}`: Delete a continent by ID.

  Example:  
  curl -X DELETE http://localhost:8080/api/location/continent/1

### Country Endpoints

- **POST** `/api/location/country`: Create a new country.

  Example:  
  curl -X POST http://localhost:8080/api/location/country  
  -H "Content-Type: application/json"  
  -d '{  
  "countryName": "Finland",  
  "continent": {  
  "continentId": 1  
  }  
  }'

- **GET** `/api/location/get-countries`: Get all countries.

  Example:  
  curl -X GET http://localhost:8080/api/location/get-countries

- **GET** `/api/location/country/{id}/get-cities`: Get all cities in a country by country ID.

  Example:  
  curl -X GET http://localhost:8080/api/location/country/1/get-cities

- **GET** `/api/location/country/{id}/get-continent`: Get the continent a country belongs to by country ID.

  Example:  
  curl -X GET http://localhost:8080/api/location/country/1/get-continent

- **PUT** `/api/location/country/{id}`: Update an existing country by ID.

  Example:  
  curl -X PUT http://localhost:8080/api/location/country/1  
  -H "Content-Type: application/json"  
  -d '{  
  "countryName": "Updated Country Name",
  "continent": {  
    "continentId": 1  
  }  
  }'

- **DELETE** `/api/location/country/{id}`: Delete a country by ID.

  Example:  
  curl -X DELETE http://localhost:8080/api/location/country/1

### City Endpoints

- **POST** `/api/location/city`: Create a new city.

  Example:  
  curl -X POST http://localhost:8080/api/location/city  
  -H "Content-Type: application/json"  
  -d '{  
  "cityName": "Helsinki",
  "country": {  
  "countryId": 1  
  }  
  }'

- **GET** `/api/location/get-cities`: Get all cities.

  Example:  
  curl -X GET http://localhost:8080/api/location/get-cities

- **GET** `/api/location/city/{id}/get-country`: Get the country a city belongs to by city ID.

  Example:  
  curl -X GET http://localhost:8080/api/location/city/1/get-country

- **PUT** `/api/location/city/{id}`: Update an existing city by ID.

  Example:  
  curl -X PUT http://localhost:8080/api/location/city/1  
  -H "Content-Type: application/json"  
  -d '{  
  "cityName": "Updated City Name",
  "country": {  
  "countryId": 1  
  }  
  }'

- **DELETE** `/api/location/city/{id}`: Delete a city by ID.

  Example:  
  curl -X DELETE http://localhost:8080/api/location/city/1



