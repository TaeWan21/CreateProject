package org.example.rats.dto.shelter;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Head {
    @Getter(onMethod_ = {@JsonProperty("totalCount")})
    @Setter(onMethod_ = {@JsonProperty("totalCount")})
    private Long totalCount;
    @Getter(onMethod_ = {@JsonProperty("numOfRows")})
    @Setter(onMethod_ = {@JsonProperty("numOfRows")})
    private String numOfRows;
    @Getter(onMethod_ = {@JsonProperty("pageNo")})
    @Setter(onMethod_ = {@JsonProperty("pageNo")})
    private String pageNo;
    private String type;
    @Getter(onMethod_ = {@JsonProperty("RESULT")})
    @Setter(onMethod_ = {@JsonProperty("RESULT")})
    private Result result;
}
