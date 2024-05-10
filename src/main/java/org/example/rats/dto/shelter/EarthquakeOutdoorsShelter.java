package org.example.rats.dto.shelter;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class EarthquakeOutdoorsShelter {
    @Getter(onMethod_ = {@JsonProperty("head")})
    @Setter(onMethod_ = {@JsonProperty("head")})
    private List<Head> head;
    @Getter(onMethod_ = {@JsonProperty("row")})
    @Setter(onMethod_ = {@JsonProperty("row")})
    private List<Row> row;
}
