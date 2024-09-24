package fi.alforza.location.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class City {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cityId;

    @Setter
    @Getter
    private String cityName;

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    // Default constructor
    public City() {}

    // Constructor with fields
    public City(Long cityId, String cityName, Country country) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.country = country;
    }
}
