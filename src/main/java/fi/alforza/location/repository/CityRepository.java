package fi.alforza.location.repository;

import fi.alforza.location.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
