package org.example.rats.dto.shelter;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Result {
    @Getter(onMethod_ = {@JsonProperty("resultCode")})
    @Setter(onMethod_ = {@JsonProperty("resultCode")})
    private String resultCode;
    @Getter(onMethod_ = {@JsonProperty("resultMsg")})
    @Setter(onMethod_ = {@JsonProperty("resultMsg")})
    private String resultMsg;
}
