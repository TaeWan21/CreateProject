package org.example.rats.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.rats.dto.interimHousing.Row;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class InterimHousingInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "area_code")
    private String arcd;// 지역코드

    @Column(name = "facility_serial_number")
    private String acmdfclty_sn; // 시설일련번호

    @Column(name = "city_name")
    private String ctprvn_nm; //시도명

    @Column(name = "township_name")
    private String sgg_nm;// 시군구명

    @Column(name = "facility_name")
    private String vt_acmdfclty_nm;// 시설명

    @Column(name = "road_code")
    private String rdnmadr_cd;// 도로명주소코드

    @Column(name = "bdong_code")
    private String bdong_cd;// 법정동코드

    @Column(name = "hdong_code")
    private String hdong_cd;// 행정동코드

    @Column(name = "detail_address")
    private String dtl_adres;// 상세주소

    @Column(name = "facility_area")
    private String fclty_ar;// 시설면적

    @Column(name = "longitude")
    private String xcord;// 경도

    @Column(name = "latitude")
    private String ycord;// 위도

    @Column(name = "management_name")
    private String mngps_nm;// 관리부서

    @Column(name = "management_telephone")
    private String mngps_telno;// 관리기관전화번호

    @Column(name = "facility_detail_name")
    private String acmdfclty_dtl_cn; // 지진겸용 임시주거시실 상세시설명

    @Column(name = "maximum_capacity")
    private String vt_acmd_psbl_nmpr;// 최대수용인원수

    @Column(name = "road_address")
    private String rn_adres;// 도로명주소

    @Column(name = "management_department_name")
    private String mngdpt_nm; // 관리기관명

    @Transient
    public static InterimHousingInfo from(Row row){
        return InterimHousingInfo.builder()
                .vt_acmd_psbl_nmpr(row.getVtAcmdfcltyNm())
                .arcd(row.getArcd())
                .acmdfclty_dtl_cn(row.getAcmdfcltyDtlCn())
                .acmdfclty_sn(row.getAcmdfcltyDtlCn())
                .bdong_cd(row.getBdongCd())
                .ctprvn_nm(row.getCtprvnNm())
                .dtl_adres(row.getDtlAdres())
                .fclty_ar(row.getAcmdfcltyDtlCn())
                .hdong_cd(row.getHdongCd())
                .mngdpt_nm(row.getMngdptNm())
                .mngps_nm(row.getMngpsNm())
                .mngps_telno(row.getMngpsTelno())
                .rdnmadr_cd(row.getRdnmadrCd())
                .rn_adres(row.getRnAdres())
                .sgg_nm(row.getSggNm())
                .vt_acmdfclty_nm(row.getVtAcmdfcltyNm())
                .xcord(row.getXcord())
                .ycord(row.getYcord())
                .build();
    }
}
