package fi.alforza.location.repository;

import fi.alforza.location.model.Continent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContinentRepository extends JpaRepository<Continent, Long> {
}
