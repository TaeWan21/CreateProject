package org.example.rats.service;

import lombok.RequiredArgsConstructor;
import org.example.rats.entity.InterimHousingInfo;
import org.example.rats.repository.jpa.InterimHousingInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class InterimHousingService {
    private final InterimHousingInfoRepository interimRepository;

    // 전체 주거시설 조회
    public List<InterimHousingInfo> findAllInterimInfos() {
        return interimRepository.findAll();
    }
}
