package com.learn.sampleapp;

import com.learn.sampleapp.model.Citizen;
import com.learn.sampleapp.model.User;
import com.learn.sampleapp.model.VaccinationCenter;
import com.learn.sampleapp.repository.CenterRepository;
import com.learn.sampleapp.repository.CitizenRepository;
import com.learn.sampleapp.repository.UserRepository;
import com.learn.sampleapp.service.CitizenService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class SampleappApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SampleappApplication.class, args);
        CenterRepository centerRepository = context.getBean(CenterRepository.class);

//        VaccinationCenter vc1 = new VaccinationCenter();
//        vc1.setCenterCity("Bengaluru");
//        vc1.setCenterName("PQR");
//        centerRepository.save(vc1);
//
//        VaccinationCenter vc2 = new VaccinationCenter();
//        vc2.setCenterCity("Mumbai");
//        vc2.setCenterName("ABC");
//        centerRepository.save(vc2);
//
//        VaccinationCenter vc3 = new VaccinationCenter();
//        vc3.setCenterCity("Pune");
//        vc3.setCenterName("Central");
//        centerRepository.save(vc3);
//
//        Citizen citizen = new Citizen();
//        citizen.setVaccinationCenter(vc1);
//        citizen.setCitizenCity("Mumbai");
//        citizen.setCitizenName("Alex");
//        citizen.setCitizenDoses(0);
//        CitizenRepository citizenRepository = context.getBean(CitizenRepository.class);
//        citizenRepository.save(citizen);

//        System.out.println(c);

        /*Optional<VaccinationCenter> data = centerRepository.findById(1);
        System.out.println(data.get());
        UserRepository userRepository = context.getBean(UserRepository.class);
        User user = new User();
        user.setUser_name("Waseem Attar");
        user.setUser_email("waseem@gmail.com");

        User u1 = userRepository.save(user);
        System.out.println(u1);

        Optional<User> optionalUser = userRepository.findById(1);
        System.out.println(optionalUser.get());

        Citizen c1 = new Citizen();
        c1.setCitizenName("Alex");
        c1.setCitizenCity("Mumbai");
        c1.setCenterId(1);
        c1.setCitizenDoses(0);
        CitizenRepository citizenRepository = context.getBean(CitizenRepository.class);
        citizenRepository.save(c1);*/
    }

}
