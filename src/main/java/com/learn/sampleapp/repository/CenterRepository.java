package com.learn.sampleapp.repository;

import com.learn.sampleapp.model.Citizen;
import com.learn.sampleapp.model.VaccinationCenter;
import org.springframework.data.repository.CrudRepository;



public interface CenterRepository extends CrudRepository<VaccinationCenter, Integer> {

}
