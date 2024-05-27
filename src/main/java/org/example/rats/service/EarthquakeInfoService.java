package org.example.rats.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.rats.dto.earthquakeInfo.Item;
import org.example.rats.dto.earthquakeInfo.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class EarthquakeInfoService {
    private final ObjectMapper objectMapper;

    public List<Item> getEarthquakeInfo() throws IOException {
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

        Response info = objectMapper.readValue(urlObj, Response.class);

        //테스트를 위해 대한민국에 임의의 지진 정보를 추가
        Item item1 = new Item();
        item1.setLoc("대한민국 금오공대 금오지");
        item1.setLat("36.141787443678");
        item1.setLon("128.395795435");
        item1.setMt("5.0");

        Item item2 = new Item();
        item2.setLoc("대한민국 금오공대 운동장");
        item2.setLat("36.146080");
        item2.setLon("128.387574");
        item2.setMt("3.0");

        Item item3 = new Item();
        item3.setLoc("대한민국 금오공대 옆 산골짜기");
        item3.setLat("36.140266");
        item3.setLon("128.386423");
        item3.setMt("7.9");

        info.getResponse().getBody().getItems().getItems().add(item1);
        info.getResponse().getBody().getItems().getItems().add(item2);
        info.getResponse().getBody().getItems().getItems().add(item3);

        return filterItems(info.getResponse().getBody().getItems().getItems());
    }

    // 대한민국에 해당하는 지진 정보만 필터링
    public List<Item> filterItems(List<Item> items) {
        return items.stream()
                .filter(item -> item.getLoc().contains("대한민국")).collect(Collectors.toList());
    }
}
