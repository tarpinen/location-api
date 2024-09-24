package fi.alforza.location.service;

import fi.alforza.location.model.Continent;
import fi.alforza.location.repository.ContinentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

class ContinentServiceTest {

    @Mock
    private ContinentRepository continentRepository;

    @InjectMocks
    private ContinentService continentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // Test for retrieving all continents
    @Test
    void testGetAllContinents() {
        when(continentRepository.findAll()).thenReturn(List.of(new Continent( 1L, "Asia", null)));

        List<Continent> continents = continentService.getAllContinents();

        assertEquals("Asia", continents.get(0).getContinentName());
    }

    // Test for saving a continent
    @Test
    void testSaveContinent() {
        Continent continent = new Continent(1L, "Africa", null);
        when(continentRepository.save(continent)).thenReturn(continent);

        Continent savedContinent = continentService.saveContinent(continent);

        assertEquals("Africa", savedContinent.getContinentName());
    }

    // Test for updating a continent
    @Test
    void testUpdateContinent() {
        Continent continent = new Continent(1L, "Africa", null);
        when(continentRepository.findById(1L)).thenReturn(Optional.of(continent));
        when(continentRepository.save(continent)).thenReturn(continent);

        Optional<Continent> updatedContinent = continentService.updateContinent(1L, continent);

        assertEquals("Africa", updatedContinent.get().getContinentName());
    }

    // Test for deleting a continent
    @Test
    void testDeleteContinent() {
        Continent continent = new Continent(1L, "Africa", null);
        when(continentRepository.findById(1L)).thenReturn(Optional.of(continent));
        doNothing().when(continentRepository).delete(continent);

        boolean isDeleted = continentService.deleteContinent(1L);

        assertTrue(isDeleted);
    }
}