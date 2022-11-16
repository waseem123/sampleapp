package com.learn.sampleapp.service;

import com.learn.sampleapp.dto.CitizenCenterDTO;
import com.learn.sampleapp.model.Citizen;
import com.learn.sampleapp.repository.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CitizenService {
    @Autowired
    CitizenRepository citizenRepository;

    public List<Citizen> getAllCitizens() {
        List<Citizen> citizens = new ArrayList<>();
        citizenRepository.findAll().forEach(citizens::add);
        return citizens;
    }

    public List<CitizenCenterDTO> getCitizens() {
        List<CitizenCenterDTO> citizens = new ArrayList<>();
        citizenRepository.fetchCenterWiseCitizens().forEach(citizens::add);
        return citizens;
    }

    public Citizen getCitizen(Long id) {
        Optional<Citizen> optional = citizenRepository.findById(id);
        Citizen c = optional.get();
        return c;
    }

    public CitizenCenterDTO getCenterwiseCitizen(Long id) {
        CitizenCenterDTO citizen = citizenRepository.fetchCenterWiseCitizen(id);
        return citizen;
    }

    public List<CitizenCenterDTO> findAllCitizens(int id) {
        return citizenRepository.findByCenterId(id);
    }

    public Citizen saveCitizen(Citizen citizen) {
        return citizenRepository.save(citizen);
    }

    public void deleteCitizen(Long id){
        citizenRepository.deleteById(id);
    }
}
