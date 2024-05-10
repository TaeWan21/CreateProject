package org.example.rats.dto.shelter;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Row {
    @Getter(onMethod_ = {@JsonProperty("arcd")})
    @Setter(onMethod_ = {@JsonProperty("arcd")})
    private String arcd;
    @Getter(onMethod_ = {@JsonProperty("acmdfclty_sn")})
    @Setter(onMethod_ = {@JsonProperty("acmdfclty_sn")})
    private long acmdfcltySn;
    @Getter(onMethod_ = {@JsonProperty("ctprvn_nm")})
    @Setter(onMethod_ = {@JsonProperty("ctprvn_nm")})
    private String ctprvnNm;
    @Getter(onMethod_ = {@JsonProperty("sgg_nm")})
    @Setter(onMethod_ = {@JsonProperty("sgg_nm")})
    private String sggNm;
    @Getter(onMethod_ = {@JsonProperty("vt_acmdfclty_nm")})
    @Setter(onMethod_ = {@JsonProperty("vt_acmdfclty_nm")})
    private String vtAcmdfcltyNm;
    @Getter(onMethod_ = {@JsonProperty("rdnmadr_cd")})
    @Setter(onMethod_ = {@JsonProperty("rdnmadr_cd")})
    private String rdnmadrCD;
    @Getter(onMethod_ = {@JsonProperty("bdong_cd")})
    @Setter(onMethod_ = {@JsonProperty("bdong_cd")})
    private String bdongCD;
    @Getter(onMethod_ = {@JsonProperty("hdong_cd")})
    @Setter(onMethod_ = {@JsonProperty("hdong_cd")})
    private String hdongCD;
    @Getter(onMethod_ = {@JsonProperty("dtl_adres")})
    @Setter(onMethod_ = {@JsonProperty("dtl_adres")})
    private String dtlAdres;
    @Getter(onMethod_ = {@JsonProperty("fclty_ar")})
    @Setter(onMethod_ = {@JsonProperty("fclty_ar")})
    private long fcltyAr;
    @Getter(onMethod_ = {@JsonProperty("xcord")})
    @Setter(onMethod_ = {@JsonProperty("xcord")})
    private String xcord;
    @Getter(onMethod_ = {@JsonProperty("ycord")})
    @Setter(onMethod_ = {@JsonProperty("ycord")})
    private String ycord;
    @Getter(onMethod_ = {@JsonProperty("mngps_nm")})
    @Setter(onMethod_ = {@JsonProperty("mngps_nm")})
    private String mngpsNm;
    @Getter(onMethod_ = {@JsonProperty("mngps_telno")})
    @Setter(onMethod_ = {@JsonProperty("mngps_telno")})
    private String mngpsTelno;
    @Getter(onMethod_ = {@JsonProperty("vt_acmd_psbl_nmpr")})
    @Setter(onMethod_ = {@JsonProperty("vt_acmd_psbl_nmpr")})
    private long vtAcmdPsblNmpr;
    @Getter(onMethod_ = {@JsonProperty("acmdfclty_se_nm")})
    @Setter(onMethod_ = {@JsonProperty("acmdfclty_se_nm")})
    private String acmdfcltySENm;
    @Getter(onMethod_ = {@JsonProperty("rn_adres")})
    @Setter(onMethod_ = {@JsonProperty("rn_adres")})
    private String rnAdres;
}
