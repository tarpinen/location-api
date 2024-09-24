package fi.alforza.location.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
public class Country {

    // Getters and Setters
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long countryId;

    @Setter
    @Getter
    private String countryName;

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "continent_id")
    private Continent continent;

    @Setter
    @Getter
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
