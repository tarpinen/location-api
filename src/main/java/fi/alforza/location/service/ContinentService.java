package fi.alforza.location.service;

import fi.alforza.location.model.*;
import fi.alforza.location.repository.ContinentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContinentService {

    @Autowired
    private ContinentRepository continentRepository;

    public List<Continent> getAllContinents() {
        return continentRepository.findAll();
    }

    public List<Country> getCountriesByContinentId(Long continentId) {
        Optional<Continent> continentOptional = continentRepository.findById(continentId);
        if (continentOptional.isPresent()) {
            return continentOptional.get().getCountries();  // Returns the list of countries
        }
        return null;
    }
    public Continent saveContinent(Continent continent) {
        return continentRepository.save(continent);
    }

    public Optional<Continent> updateContinent(Long id, Continent updatedContinentDetails) {
        Optional<Continent> continentOptional = continentRepository.findById(id);
        if (continentOptional.isPresent()) {
            Continent continent = continentOptional.get();
            continent.setContinentName(updatedContinentDetails.getContinentName());
            return Optional.of(continentRepository.save(continent));
        }
        return Optional.empty();
    }

    public boolean deleteContinent(Long id) {
        Optional<Continent> continent = continentRepository.findById(id);
        if (continent.isPresent()) {
            continentRepository.delete(continent.get());
            return true;
        }
        return false;
    }

}

