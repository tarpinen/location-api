package fi.alforza.location.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
public class Continent {

    @Id
    @Setter
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long continentId;

    @Setter
    @Getter
    private String continentName;

    @Setter
    @Getter
    @JsonIgnore
    @OneToMany(mappedBy = "continent", cascade = CascadeType.ALL)
    private List<Country> countries;

    // Default constructor
    public Continent() {}

    // Constructor with fields
    public Continent(String continentName) {
        this.continentName = continentName;
    }
}