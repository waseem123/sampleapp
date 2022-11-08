package com.learn.sampleapp.repository;

import com.learn.sampleapp.model.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CenterRepository extends CrudRepository<VaccinationCenter, Integer> {
}
