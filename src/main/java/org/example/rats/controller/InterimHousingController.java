package org.example.rats.controller;

import lombok.RequiredArgsConstructor;
import org.example.rats.entity.InterimHousingInfo;
import org.example.rats.service.InterimHousingService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin
@RestController
@RequiredArgsConstructor
public class InterimHousingController {
    private final InterimHousingService interimHousingService;

    @GetMapping("/interimHousing/findAll")
    public List<InterimHousingInfo> findAll() {
        return interimHousingService.findAllInterimInfos();
    }
}
