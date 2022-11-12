package com.learn.sampleapp;

import com.learn.sampleapp.model.Citizen;
import com.learn.sampleapp.model.User;
import com.learn.sampleapp.model.VaccinationCenter;
import com.learn.sampleapp.repository.CenterRepository;
import com.learn.sampleapp.repository.CitizenRepository;
import com.learn.sampleapp.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class SampleappApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SampleappApplication.class, args);
        /*CenterRepository centerRepository = context.getBean(CenterRepository.class);
        VaccinationCenter vc = new VaccinationCenter();
        vc.setCenterCity("Mumbai");
        vc.setCenterName("ABC");

        VaccinationCenter c = centerRepository.save(vc);
        System.out.println(c);

        Optional<VaccinationCenter> data = centerRepository.findById(1);
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
