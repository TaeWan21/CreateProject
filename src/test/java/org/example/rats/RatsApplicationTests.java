package org.example.rats;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.rats.dto.earthquakeInfo.EarthquakeInfoResponse;
import org.example.rats.dto.earthquakeInfo.Response;
import org.example.rats.dto.interimHousing.EarthquakeResponse;
import org.example.rats.dto.interimHousing.Row;
import org.example.rats.entity.InterimHousingInfo;
import org.example.rats.entity.ShelterInfo;
import org.example.rats.dto.shelter.ShelterResponse;
import org.example.rats.repository.jpa.InterimHousingInfoRepository;
import org.example.rats.repository.jpa.ShelterInfoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class RatsApplicationTests {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    ShelterInfoRepository shelterInfoRepository;

    @Autowired
    InterimHousingInfoRepository interimHousingInfoRepository;

    @Test
    void saveShelterAPIToDB() throws IOException {

        for (int pageNo = 1; pageNo <= 12; pageNo++) {
            int numOfRows = 1000;
            String serviceKey = "v6JyEA3awH%2FtsTfbPzCUp4ml2PWMZf06Iz2WVDph4KoAH6rRh5vhw8vbIHyLTzDeaswzIvQH6E2VdRPR41%2Fwxw%3D%3D";
            String apiUrl = "https://apis.data.go.kr/1741000/EarthquakeIndoors3/getEarthquakeIndoors3List?serviceKey={0}&pageNo={1}&numOfRows={2}&type=json";

            String url = MessageFormat.format(apiUrl, serviceKey, Integer.toString(pageNo), Integer.toString(numOfRows));
            URL urlObj = new URL(url);
            ShelterResponse shelterResponse = objectMapper.readValue(urlObj, ShelterResponse.class);

            List<org.example.rats.dto.shelter.Row> row = shelterResponse.getEarthquakeOutdoorsShelter().get(1).getRow(); // 1000개

            List<ShelterInfo> silist = new ArrayList<>();
            row.forEach(row1 -> {
                ShelterInfo si = ShelterInfo.from(row1);
                silist.add(si);
            });
            shelterInfoRepository.saveAllAndFlush(silist);
        }
    }

    @Test
    void saveInterimHousingAPIToDB() throws IOException {
        String serviceKey = "v6JyEA3awH%2FtsTfbPzCUp4ml2PWMZf06Iz2WVDph4KoAH6rRh5vhw8vbIHyLTzDeaswzIvQH6E2VdRPR41%2Fwxw%3D%3D";
        for (int pageNo = 1; pageNo <= 6; pageNo++) {
            int numOfRows = 1000;

            String apiUrl = "https://apis.data.go.kr/1741000/EarthquakeIndoors3/getEarthquakeIndoors3List?serviceKey={0}&pageNo={1}&numOfRows={2}&type=json";

            String url = MessageFormat.format(apiUrl, serviceKey, Integer.toString(pageNo), Integer.toString(numOfRows));
            URL urlObj = new URL(url);
            EarthquakeResponse earthquakeResponse = objectMapper.readValue(urlObj, EarthquakeResponse.class);

//            System.out.println(earthquakeResponse);
            List<Row> row = earthquakeResponse.getEarthquakeIndoors().get(1).getRow(); // 1000개
            System.out.println(row.size());
            List<InterimHousingInfo> silist = new ArrayList<>();
            row.forEach(info -> {
                InterimHousingInfo ihInfo = InterimHousingInfo.from(info);
                silist.add(ihInfo);
            });
            interimHousingInfoRepository.saveAllAndFlush(silist);
        }
    }

    @Test
    void EarthquakeInfoTest() throws IOException {
        String serviceKey = "v6JyEA3awH%2FtsTfbPzCUp4ml2PWMZf06Iz2WVDph4KoAH6rRh5vhw8vbIHyLTzDeaswzIvQH6E2VdRPR41%2Fwxw%3D%3D";
        int numOfRows = 50;
        String apiUrl = "https://apis.data.go.kr/1360000/EqkInfoService/getEqkMsg?serviceKey={0}&pageNo=1&numOfRows=50&dataType=json&fromTmFc={1}&toTmFc={2}";
        // 현재 날짜 구하기
        LocalDate now = LocalDate.now();

        // 현재로부터 3일뺴기
        LocalDate minusThreeDays = now.minusDays(3);

        // 포맷 정의
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        // 포맷 적용
        String nowDate = now.format(formatter);
        String minusThreeDaysDate = minusThreeDays.format(formatter);

        String url = MessageFormat.format(apiUrl, serviceKey, minusThreeDaysDate, nowDate);

        URL urlObj = new URL(url);

        Response Info = objectMapper.readValue(urlObj, Response.class);
    }

}
