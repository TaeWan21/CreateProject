package org.example.rats.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.rats.entity.ShelterInfo;
import org.example.rats.service.ShelterService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@Slf4j
public class ShelterController {

    public final ShelterService shelterService;

    @GetMapping("/shelter/findAll")
    public List<ShelterInfo> findAll() {
        return shelterService.findAllShelterInfos();
    }
}
