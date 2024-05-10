package org.example.rats.dto.interimHousing;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EarthquakeIndoors {
    private List<Head> head;
    private List<Row> row;
}
