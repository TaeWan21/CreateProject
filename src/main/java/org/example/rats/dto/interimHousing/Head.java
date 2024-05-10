package org.example.rats.dto.interimHousing;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Head {
    private String totalCount;
    private String numOfRows;
    private String pageNo;
    private String type;
    private Result RESULT;

}


