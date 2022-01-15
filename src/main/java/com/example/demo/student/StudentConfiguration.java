package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.DECEMBER;

@Configuration
public class StudentConfiguration {
    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository studentRepository){
        return args -> {
            Student philipos = new Student(
                    "Philipos",
                    LocalDate.of(1998, DECEMBER, 22),
                    "pasmare@miu.edu"

            );
            Student yad = new Student(
                    "Yad",
                    LocalDate.of(200, 11, 21),
                    "a@miu.edu"
            );
            studentRepository.saveAll(List.of(philipos, yad));
        };
    }
}
