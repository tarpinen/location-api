package fi.alforza.location.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity @Getter @Setter
public class Continent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long continentId;

    @NotBlank(message = "Continent name is required")
    private String continentName;

    @JsonIgnore
    @OneToMany(mappedBy = "continent", cascade = CascadeType.ALL)
    private List<Country> countries;

    // Default constructor
    public Continent() {}

    // Constructor with fields
    public Continent(Long continentId, String continentName, List<Country> countries) {
        this.continentId = continentId;
        this.continentName = continentName;
        this.countries = countries;
    }
}