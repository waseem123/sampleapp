package com.learn.sampleapp.repository;

import com.learn.sampleapp.dto.CitizenCenterDTO;
import com.learn.sampleapp.model.Citizen;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CitizenRepository extends CrudRepository<Citizen, Long> {
    //    @EntityGraph(value = "VaccinationCenter.citizen", type = EntityGraph.EntityGraphType.FETCH)
    List<Citizen> findByCenterId(int center_id);

        @Query(value = "SELECT new com.learn.sampleapp.dto.CitizenCenterDTO(v.centerName,c.citizenId,c.citizenName,c.citizenCity,c.citizenDoses)" +
            " FROM Citizen c JOIN c.vaccinationCenter v")
//    @Query(value = "SELECT a.citizen_id,a.citizen_city,a.citizen_name,a.citizen_doses,b.center_name FROM citizen a JOIN vaccination_center b\n" +
//            "ON a.vcenter_id = b.center_id", nativeQuery = true)
    List<CitizenCenterDTO> fetchCenterWiseCitizens();
}
