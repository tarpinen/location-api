package fi.alforza.location.service;

import fi.alforza.location.model.*;
import fi.alforza.location.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public Country saveCountry(Country country) {
        return countryRepository.save(country);
    }

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public Optional<Country> findByContinentId(Long id) {
        return countryRepository.findById(id);
    }

    public List<City> getCitiesByCountryId(Long countryId) {
        Optional<Country> countryOptional = countryRepository.findById(countryId);
        if (countryOptional.isPresent()) {
            return countryOptional.get().getCities();  // Returns the list of cities
        }
        return null;  // or throw a custom exception if country is not found
    }

    // Update an existing country
    public Optional<Country> updateCountry(Long id, Country updatedCountry) {
        Optional<Country> existingCountry = countryRepository.findById(id);
        if (existingCountry.isPresent()) {
            Country country = existingCountry.get();
            country.setCountryName(updatedCountry.getCountryName());
            country.setContinent(updatedCountry.getContinent());
            return Optional.of(countryRepository.save(country));
        }
        return Optional.empty();
    }

    // Delete a country by ID
    public boolean deleteCountry(Long id) {
        Optional<Country> country = countryRepository.findById(id);
        if (country.isPresent()) {
            countryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}