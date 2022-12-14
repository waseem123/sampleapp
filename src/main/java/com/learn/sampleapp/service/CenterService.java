package com.learn.sampleapp.service;

import com.learn.sampleapp.model.VaccinationCenter;
import com.learn.sampleapp.repository.CenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CenterService {
    @Autowired
    private CenterRepository centerRepository;

    public List<VaccinationCenter> getAllCenters() {
        List<VaccinationCenter> centers = new ArrayList<>();
        centerRepository.findAll().forEach(centers::add);
        return centers;
    }

    public VaccinationCenter addCenter(VaccinationCenter vaccinationCenter) {
        return centerRepository.save(vaccinationCenter);
    }

    public VaccinationCenter getCenters(int id) {
        Optional<VaccinationCenter> vc = centerRepository.findById(id);
        return vc.get();
    }

    public void deleteCenter(int id) {
        centerRepository.deleteById(id);
    }
}
