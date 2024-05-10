package org.example.rats.repository.jpa;

import org.example.rats.entity.InterimHousingInfo;
import org.example.rats.entity.ShelterInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterimHousingInfoRepository extends JpaRepository<InterimHousingInfo, Long> {
}
