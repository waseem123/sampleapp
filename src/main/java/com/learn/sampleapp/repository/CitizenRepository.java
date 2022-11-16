package com.learn.sampleapp.repository;

import com.learn.sampleapp.dto.CitizenCenterDTO;
import com.learn.sampleapp.model.Citizen;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CitizenRepository extends CrudRepository<Citizen, Long> {
//    List<Citizen> findByCenterId(int center_id);

    @Query(value = "SELECT new com.learn.sampleapp.dto.CitizenCenterDTO(v.centerName,v.centerId,c.citizenId,c.citizenName,c.citizenCity,c.citizenDoses)" +
            " FROM Citizen c JOIN c.vaccinationCenter v")
    List<CitizenCenterDTO> fetchCenterWiseCitizens();

    @Query(value = "SELECT new com.learn.sampleapp.dto.CitizenCenterDTO(v.centerName,v.centerId,c.citizenId,c.citizenName,c.citizenCity,c.citizenDoses)" +
            " FROM Citizen c JOIN c.vaccinationCenter v" +
            " WHERE c.citizenId = :citizen_id")
    CitizenCenterDTO fetchCenterWiseCitizen(@Param("citizen_id") long citizen_id);

    @Query(value = "SELECT new com.learn.sampleapp.dto.CitizenCenterDTO(v.centerName,v.centerId,c.citizenId,c.citizenName,c.citizenCity,c.citizenDoses)" +
            " FROM Citizen c JOIN c.vaccinationCenter v" +
            " WHERE v.centerId = :center_id")
    List<CitizenCenterDTO> findByCenterId(@Param("center_id") int center_id);
}
