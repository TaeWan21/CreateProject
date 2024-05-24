package org.example.rats.controller;

import lombok.RequiredArgsConstructor;
import org.example.rats.dto.earthquakeInfo.Item;
import org.example.rats.service.EarthquakeInfoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class EarthquakeInfoController {
    private final EarthquakeInfoService earthquakeInfoService;

    @GetMapping("/earthquakeInfo")
    public List<Item> earthquakeInfo() throws IOException {
        return earthquakeInfoService.getEarthquakeInfo();
    }
}
