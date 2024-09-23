package fi.alforza.location.service;

import fi.alforza.location.model.City;
import fi.alforza.location.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    // Get all cities
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    // Save a new city
    public City saveCity(City city) {
        return cityRepository.save(city);
    }

    // Find a city by ID
    public Optional<City> findById(Long id) {
        return cityRepository.findById(id);
    }

    // Update an existing city
    public Optional<City> updateCity(Long id, City updatedCity) {
        Optional<City> existingCity = cityRepository.findById(id);
        if (existingCity.isPresent()) {
            City city = existingCity.get();
            city.setCityName(updatedCity.getCityName());
            city.setCountry(updatedCity.getCountry());
            return Optional.of(cityRepository.save(city));
        }
        return Optional.empty();
    }

    // Delete a city by ID
    public boolean deleteCity(Long id) {
        Optional<City> city = cityRepository.findById(id);
        if (city.isPresent()) {
            cityRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
