package fi.alforza.location.service;

import fi.alforza.location.model.City;
import fi.alforza.location.repository.CityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;



class CityServiceTest {

    @Mock
    private CityRepository cityRepository;

    @InjectMocks
    private CityService cityService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // Test for retrieving all cities
    @Test
    void testGetAllCities() {
        when(cityRepository.findAll()).thenReturn(List.of(new City(1L,"Mumbai", null)));

        List<City> cities = cityService.getAllCities();

        assertEquals("Mumbai", cities.get(0).getCityName());
    }

    // Test for saving a city
    @Test
    void testSaveCity() {
        City city = new City(1L, "Mumbai", null);
        when(cityRepository.save(city)).thenReturn(city);

        City savedCity = cityService.saveCity(city);

        assertEquals("Mumbai", savedCity.getCityName());
    }

    // Test for updating a city
    @Test
    void testUpdateCity() {
        City city = new City(1L, "Mumbai", null);
        when(cityRepository.findById(1L)).thenReturn(Optional.of(city));
        when(cityRepository.save(city)).thenReturn(city);

        Optional<City> updatedCity = cityService.updateCity(1L, city);

        assertEquals("Mumbai", updatedCity.get().getCityName());
    }

    // Test for deleting a city
    @Test
    void testDeleteCity() {
        City city = new City(1L, "Mumbai", null);
        when(cityRepository.findById(1L)).thenReturn(Optional.of(city));
        doNothing().when(cityRepository).delete(city);

        boolean isDeleted = cityService.deleteCity(1L);

        assertTrue(isDeleted);
    }
}
