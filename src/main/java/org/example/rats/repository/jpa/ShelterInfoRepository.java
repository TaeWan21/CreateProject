package org.example.rats.repository.jpa;

import org.example.rats.entity.ShelterInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShelterInfoRepository extends JpaRepository<ShelterInfo, Long> {


    @Query(
            value = "SELECT *, ST_DISTANCE_SPHERE(location, POINT(:long, :lati)) AS distance " +
                    "FROM shelter_info " +
                    "WHERE MBRContains( " +
                    "    LineString(\n" +
                    "        Point(:long - 0.045 / COS(RADIANS(:lati)), :lati - 0.045), " +
                    "        Point(:long + 0.045 / COS(RADIANS(:lati)), :lati + 0.045) " +
                    "    ), " +
                    "    location " +
                    ") " +
                    "AND ST_DISTANCE_SPHERE(location, POINT(:long, :lati)) <= 3000 " +
                    "ORDER BY distance ",
            nativeQuery = true
    )
    List<ShelterInfo> findNearShelterByLocation(@Param("lati") double latitude, @Param("long") double longitude);
}
