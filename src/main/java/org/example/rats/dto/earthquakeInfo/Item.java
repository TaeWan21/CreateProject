package org.example.rats.dto.earthquakeInfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @JsonProperty("cnt")
    private String cnt;
    @JsonProperty("fcTp")
    private String fcTp;
    @JsonProperty("img")
    private String img;
    @JsonProperty("inT")
    private String inT;
    @JsonProperty("lat")
    private String lat;
    @JsonProperty("loc")
    private String loc;
    @JsonProperty("lon")
    private String lon;
    @JsonProperty("mt")
    private String mt;
    @JsonProperty("rem")
    private String rem;
    @JsonProperty("stnId")
    private String stnId;
    @JsonProperty("tmEqk")
    private String tmEqk;
    @JsonProperty("tmFc")
    private String tmFc;
    @JsonProperty("tmSeq")
    private String tmSeq;
    @JsonProperty("dep")
    private String dep;
}
