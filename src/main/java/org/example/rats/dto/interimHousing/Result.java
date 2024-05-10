package org.example.rats.dto.interimHousing;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private String resultCode;
    private String resultMsg;
}

