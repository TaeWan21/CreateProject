package org.example.rats.service;

import lombok.RequiredArgsConstructor;
import org.example.rats.entity.ShelterInfo;
import org.example.rats.repository.jpa.ShelterInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ShelterService {
    private final ShelterInfoRepository shelterInfoRepository;

    // 전체 대피소 조회
    public List<ShelterInfo> findAllShelterInfos() {
        return shelterInfoRepository.findAll();
    }
}
