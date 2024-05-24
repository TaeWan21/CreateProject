package org.example.rats.dto.earthquakeInfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Body {
    @JsonProperty("dataType")
    private String dataType;
    @JsonProperty("items")
    private Items items;
    @JsonProperty("pageNo")
    private String pageNo;
    @JsonProperty("numOfRows")
    private String numOfRows;
    @JsonProperty("totalCount")
    private String totalCount;
}
