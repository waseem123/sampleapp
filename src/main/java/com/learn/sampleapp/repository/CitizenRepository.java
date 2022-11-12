package com.learn.sampleapp.repository;

import com.learn.sampleapp.model.Citizen;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CitizenRepository extends CrudRepository<Citizen, Long> {
    List<Citizen> findByCenterId(int center_id);
}
