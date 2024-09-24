package fi.alforza.location.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity @Getter @Setter
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long countryId;

    @NotBlank(message = "Country name is required")
    private String countryName;

    @ManyToOne
    @JoinColumn(name = "continent_id")
    @NotNull(message = "Continent is required")
    private Continent continent;

    @JsonIgnore
    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private List<City> cities;

    // Default constructor
    public Country() {}

    // Constructor
    public Country(Long countryId, String countryName, Continent continent, List<City> cities) {
        this.countryId = countryId;
        this.countryName = countryName;
        this.continent = continent;
        this.cities = cities;
    }
}
