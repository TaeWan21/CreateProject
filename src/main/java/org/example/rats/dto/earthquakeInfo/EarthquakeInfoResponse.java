package org.example.rats.dto.earthquakeInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EarthquakeInfoResponse {
    private Header header;
    private Body body;
}
