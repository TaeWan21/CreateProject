package org.example.rats;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.net.URL;
import java.text.MessageFormat;
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
            String apiUrl = "https://apis.data.go.kr/1741000/EarthquakeIndoors3/getEarthquakeIndoors3List?serviceKey=v6JyEA3awH%2FtsTfbPzCUp4ml2PWMZf06Iz2WVDph4KoAH6rRh5vhw8vbIHyLTzDeaswzIvQH6E2VdRPR41%2Fwxw%3D%3D&pageNo={0}&numOfRows={1}&type=json";

            String url = MessageFormat.format(apiUrl, Integer.toString(pageNo), Integer.toString(numOfRows));
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

        for (int pageNo = 1; pageNo <= 6; pageNo++) {
            int numOfRows = 1000;
            String apiUrl = "https://apis.data.go.kr/1741000/EarthquakeIndoors3/getEarthquakeIndoors3List?serviceKey=v6JyEA3awH%2FtsTfbPzCUp4ml2PWMZf06Iz2WVDph4KoAH6rRh5vhw8vbIHyLTzDeaswzIvQH6E2VdRPR41%2Fwxw%3D%3D&pageNo={0}&numOfRows={1}&type=json";

            String url = MessageFormat.format(apiUrl, Integer.toString(pageNo), Integer.toString(numOfRows));
            URL urlObj = new URL(url);
            EarthquakeResponse earthquakeResponse = objectMapper.readValue(urlObj, EarthquakeResponse.class);

//            System.out.println(earthquakeResponse);
            List<Row> row = earthquakeResponse.getEarthquakeIndoors().getLast().getRow(); // 1000개

            List<InterimHousingInfo> silist = new ArrayList<>();
            row.forEach(info -> {
                InterimHousingInfo ihInfo = InterimHousingInfo.from(info);
                silist.add(ihInfo);
            });
            interimHousingInfoRepository.saveAllAndFlush(silist);
        }
    }

}
