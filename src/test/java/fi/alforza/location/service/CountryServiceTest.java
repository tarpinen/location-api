package fi.alforza.location.service;

import fi.alforza.location.model.Country;
import fi.alforza.location.repository.CountryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

class CountryServiceTest {

    @Mock
    private CountryRepository countryRepository;

    @InjectMocks
    private CountryService countryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // Test for retrieving all countries
    @Test
    void testGetAllCountries() {
        when(countryRepository.findAll()).thenReturn(List.of(new Country(1L, "India", null, null)));

        List<Country> countries = countryService.getAllCountries();

        assertEquals("India", countries.get(0).getCountryName());
    }

    // Test for saving a country
    @Test
    void testSaveCountry() {
        Country country = new Country(1L, "India", null, null);
        when(countryRepository.save(country)).thenReturn(country);

        Country savedCountry = countryService.saveCountry(country);

        assertEquals("India", savedCountry.getCountryName());
    }

    // Test for updating a country
    @Test
    void testUpdateCountry() {
        Country country = new Country(1L, "India", null, null);
        when(countryRepository.findById(1L)).thenReturn(Optional.of(country));
        when(countryRepository.save(country)).thenReturn(country);

        Optional<Country> updatedCountry = countryService.updateCountry(1L, country);

        assertEquals("India", updatedCountry.get().getCountryName());
    }

    // Test for deleting a country
    @Test
    void testDeleteCountry() {
        Country country = new Country(1L, "India", null, null);
        when(countryRepository.findById(1L)).thenReturn(Optional.of(country));
        doNothing().when(countryRepository).delete(country);

        boolean isDeleted = countryService.deleteCountry(1L);

        assertTrue(isDeleted);
    }
}

