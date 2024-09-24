package fi.alforza.location.controller;

import fi.alforza.location.model.*;
import fi.alforza.location.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/location")
public class LocationController {

    @Autowired
    private ContinentService continentService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private CityService cityService;


    @PostMapping("/continent")
    public ResponseEntity<Continent> createContinent(@RequestBody Continent continent) {
        Continent savedContinent = continentService.saveContinent(continent);
        return ResponseEntity.ok(savedContinent);
    }

    @GetMapping("/get-continents")
    public List<Continent> getAllContinents() {
        return continentService.getAllContinents();
    }

    @GetMapping("/continent/{id}/get-countries")
    public ResponseEntity<List<Country>> getCountriesByContinentId(@PathVariable("id") Long id) {
        List<Country> countries = continentService.getCountriesByContinentId(id);
        if (countries != null) {
            return ResponseEntity.ok(countries);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }

    @PutMapping("/continent/{id}")
    public ResponseEntity<Continent> updateContinent(@PathVariable Long id, @RequestBody Continent continentDetails) {
        Optional<Continent> updatedContinent = continentService.updateContinent(id, continentDetails);
        if (updatedContinent.isPresent()) {
            return ResponseEntity.ok(updatedContinent.get());
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }

    @DeleteMapping("/continent/{id}")
    public ResponseEntity<String> deleteContinent(@PathVariable Long id) {
        boolean deleted = continentService.deleteContinent(id);
        if (deleted) {
            return ResponseEntity.ok("Continent with ID " + id + " deleted successfully");
        } else {
            return ResponseEntity.status(404).body("Continent with ID " + id + " not found");
        }
    }

    @PostMapping("/country")
    public ResponseEntity<String> createCountry(@RequestBody Country country) {
        Country savedCountry = countryService.saveCountry(country);
        return ResponseEntity.ok("Country created successfully");
    }

    @GetMapping("/get-countries")
    public List<Country> getAllCountries() {
        return countryService.getAllCountries();
    }

    @GetMapping("/country/{id}/get-cities")
    public ResponseEntity<List<City>> getCitiesByCountryId(@PathVariable("id") Long id) {
        List<City> cities = countryService.getCitiesByCountryId(id);
        if (cities != null) {
            return ResponseEntity.ok(cities);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }

    @GetMapping("country/{id}/get-continent")
    public ResponseEntity<Continent> getContinentByCountryId(@PathVariable("id") Long id) {
        Optional<Country> countryOptional = countryService.findByContinentId(id);
        if (countryOptional.isPresent()) {
            return ResponseEntity.ok(countryOptional.get().getContinent());
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }

    @PutMapping("/country/{id}")
    public ResponseEntity<String> updateCountry(@PathVariable Long id, @RequestBody Country countryDetails) {
        Optional<Country> updatedCountry = countryService.updateCountry(id, countryDetails);
        if (updatedCountry.isPresent()) {
            return ResponseEntity.ok("Country updated successfully");
        } else {
            return ResponseEntity.status(404).body("Country does not exist");
        }
    }

    @DeleteMapping("/country/{id}")
    public ResponseEntity<String> deleteCountry(@PathVariable Long id) {
        boolean deleted = countryService.deleteCountry(id);
        if (deleted) {
            return ResponseEntity.ok("Country with ID " + id + " deleted successfully");
        } else {
            return ResponseEntity.status(404).body("Country with ID " + id + " not found");
        }
    }

    @PostMapping("/city")
    public ResponseEntity<String> createCity(@RequestBody City city) {
        City savedCity = cityService.saveCity(city);
        return ResponseEntity.ok("City created successfully");
    }

    @GetMapping("city/{id}/get-country")
    public ResponseEntity<Country> getCountryByCityId(@PathVariable("id") Long id) {
        Optional<City> cityOptional = cityService.findByCountryId(id);
        if (cityOptional.isPresent()) {
            return ResponseEntity.ok(cityOptional.get().getCountry());
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }

    @GetMapping("/get-cities")
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }

    @PutMapping("/city/{id}")
    public ResponseEntity<String> updateCity(@PathVariable Long id, @RequestBody City cityDetails) {
        Optional<City> updatedCity = cityService.updateCity(id, cityDetails);
        if (updatedCity.isPresent()) {
            return ResponseEntity.ok("City updated successfully");
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }

    @DeleteMapping("/city/{id}")
    public ResponseEntity<String> deleteCity(@PathVariable Long id) {
        boolean deleted = cityService.deleteCity(id);
        if (deleted) {
            return ResponseEntity.ok("City with ID " + id + " deleted successfully");
        } else {
            return ResponseEntity.status(404).body("City with ID " + id + " not found");
        }
    }
}