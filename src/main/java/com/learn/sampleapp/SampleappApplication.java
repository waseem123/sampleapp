package com.learn.sampleapp;

import com.learn.sampleapp.model.User;
import com.learn.sampleapp.model.VaccinationCenter;
import com.learn.sampleapp.repository.CenterRepository;
import com.learn.sampleapp.repository.UserRepository;
import org.hibernate.resource.beans.container.spi.AbstractCdiBeanContainer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class SampleappApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SampleappApplication.class, args);
//        CenterRepository centerRepository = context.getBean(CenterRepository.class);
//        VaccinationCenter vc = new VaccinationCenter();
//        vc.setCenterCity("Mumbai");
//        vc.setCenterName("ABC");
//
//        VaccinationCenter c1 = centerRepository.save(vc);
//        System.out.println(c1);
//
//        Optional<VaccinationCenter> data = centerRepository.findById(7);
//        System.out.println(data.get());
//        UserRepository userRepository = context.getBean(UserRepository.class);
//        User user = new User();
//        user.setUser_name("Waseem Attar");
//        user.setUser_city("Mumbai");
//
//        User u1 = userRepository.save(user);
//        System.out.println(u1);
//
//        Optional<User> optionalUser = userRepository.findById(2);
//        System.out.println(optionalUser.get());
    }

}
