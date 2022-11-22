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

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@SpringBootApplication
public class SampleappApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SampleappApplication.class, args);
        openHomePage();
//        CenterRepository centerRepository = context.getBean(CenterRepository.class);

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
    }
    private static void openHomePage() {
        try {
            URI homepage = new URI("http://localhost:8086/");
            if(Desktop.isDesktopSupported()){
                Desktop desktop = Desktop.getDesktop();
                try {
                    desktop.browse(homepage);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }else{
                Runtime runtime = Runtime.getRuntime();
                try {
                    runtime.exec("xdg-open " + homepage);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    System.out.println(e.getMessage());
                }
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

}
