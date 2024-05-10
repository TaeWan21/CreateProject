package org.example.rats.dto.shelter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShelterRequest {
    String ServiceKey;
    String pageNo;
    String numOfRows;
    String type;
}
