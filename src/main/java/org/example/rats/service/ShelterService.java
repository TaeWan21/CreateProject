package org.example.rats.service;

import lombok.RequiredArgsConstructor;
import org.example.rats.entity.ShelterInfo;
import org.example.rats.repository.jpa.ShelterInfoRepository;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ShelterService {
    private final ShelterInfoRepository shelterInfoRepository;

    // 전체 대피소 조회
    public List<ShelterInfo> findAllShelterInfos() {
        return shelterInfoRepository.findAll();
    }

    // 반경 3km 이내 대피소 조회
    public List<ShelterInfo> findNearShelterByLocation(double latitude, double longitude) {
        List<ShelterInfo> info = shelterInfoRepository.findNearShelterByLocation(latitude, longitude);
        for (ShelterInfo shelterInfo : info) {
            Point2D shelterLocation = new Point2D.Double(Double.parseDouble(shelterInfo.getXcord()), Double.parseDouble(shelterInfo.getYcord()));
            shelterInfo.setDistance(calculateDistance(new Point2D.Double(longitude, latitude), shelterLocation));
        }
        return info;
    }

    // 두 지점 사이의 거리를 km단위로 반환
    public double calculateDistance(Point2D point1, Point2D point2) {
        final int R = 6371; // 지구 반지름 (km)

        double latDistance = Math.toRadians(point2.getX() - point1.getX());
        double lonDistance = Math.toRadians(point2.getY() - point1.getY());

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(point1.getX())) * Math.cos(Math.toRadians(point2.getX()))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return R * c * 1000 * 0.88;
    }
}
