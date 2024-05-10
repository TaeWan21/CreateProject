package org.example.rats.dto.shelter;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class ShelterResponse {
    @Getter(onMethod_ = {@JsonProperty("EarthquakeOutdoorsShelter")})
    @Setter(onMethod_ = {@JsonProperty("EarthquakeOutdoorsShelter")})
    private List<EarthquakeOutdoorsShelter> earthquakeOutdoorsShelter;
}
