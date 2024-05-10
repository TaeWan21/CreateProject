package org.example.rats.dto.interimHousing;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Row {
    @JsonProperty("arcd")
    private String arcd;
    @JsonProperty("acmdfclty_sn")
    private String acmdfcltySn;
    @JsonProperty("ctprvn_nm")
    private String ctprvnNm;
    @JsonProperty("sgg_nm")
    private String sggNm;
    @JsonProperty("vt_acmdfclty_nm")
    private String vtAcmdfcltyNm;
    @JsonProperty("rdnmadr_cd")
    private String rdnmadrCd;
    @JsonProperty("bdong_cd")
    private String bdongCd;
    @JsonProperty("hdong_cd")
    private String hdongCd;
    @JsonProperty("dtl_adres")
    private String dtlAdres;
    @JsonProperty("fclty_ar")
    private String fcltyAr;
    @JsonProperty("xcord")
    private String xcord;
    @JsonProperty("ycord")
    private String ycord;
    @JsonProperty("mngps_nm")
    private String mngpsNm;
    @JsonProperty("mngps_telno")
    private String mngpsTelno;
    @JsonProperty("acmdfclty_dtl_cn")
    private String acmdfcltyDtlCn;
    @JsonProperty("rn_adres")
    private String rnAdres;
    @JsonProperty("mngdpt_nm")
    private String mngdptNm;
    @JsonProperty("vt_acmd_psbl_nmpr")
    private int vtAcmdPsblNmpr;
}
