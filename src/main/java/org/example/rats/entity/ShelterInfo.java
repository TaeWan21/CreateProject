package org.example.rats.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.rats.dto.shelter.Row;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class ShelterInfo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "area_code")
    private String arcd;// 지역코드

    @Column(name = "facility_serial_number")
    private long acmdfcltySn; // 시설일련번호

    @Column(name = "city_name")
    private String ctprvnNm; //시도명

    @Column(name = "township_name")
    private String sggNm;// 시군구명

    @Column(name = "facility_name")
    private String vtAcmdfcltyNm;// 시설명

    @Column(name = "road_code")
    private String rdnmadrCD;// 도로명주소코드

    @Column(name = "bdong_code")
    private String bdongCD;// 법정동코드

    @Column(name = "hdong_code")
    private String hdongCD;// 행정동코드

    @Column(name = "detail_address")
    private String dtlAdres;// 상세주소

    @Column(name = "facility_area")
    private long fcltyAr;// 시설면적

    @Column(name = "longitude")
    private String xcord;// 경도

    @Column(name = "latitude")
    private String ycord;// 위도

    @Column(name = "management_name")
    private String mngpsNm;// 관리기관명

    @Column(name = "management_telephone")
    private String mngpsTelno;// 관리기관전화번호

    @Column(name = "maximum_capacity")
    private long vtAcmdPsblNmpr;// 최대수용인원수

    @Column(name = "type_classification")
    private String acmdfcltySENm;// 지진옥외대피장소 유형구분

    @Column(name = "road_address")
    private String rnAdres;// 도로명주소

    @Transient
    private double distance;

    @Transient
    public static ShelterInfo from(Row row){
        return ShelterInfo.builder()
                .acmdfcltySENm(row.getAcmdfcltySENm())
                .acmdfcltySn(row.getFcltyAr())
                .arcd(row.getArcd())
                .dtlAdres(row.getDtlAdres())
                .bdongCD(row.getBdongCD())
                .ctprvnNm(row.getCtprvnNm())
                .hdongCD(row.getHdongCD())
                .fcltyAr(row.getFcltyAr())
                .mngpsNm(row.getMngpsNm())
                .mngpsTelno(row.getMngpsTelno())
                .rdnmadrCD(row.getRdnmadrCD())
                .rnAdres(row.getRnAdres())
                .sggNm(row.getSggNm())
                .vtAcmdfcltyNm(row.getVtAcmdfcltyNm())
                .vtAcmdPsblNmpr(row.getVtAcmdPsblNmpr())
                .xcord(row.getXcord())
                .ycord(row.getYcord())
                .build();
    }
}
