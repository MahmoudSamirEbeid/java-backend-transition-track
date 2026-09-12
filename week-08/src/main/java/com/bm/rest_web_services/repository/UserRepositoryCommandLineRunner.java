package com.bm.rest_web_services.repository;

import com.bm.rest_web_services.entity.Person;
import com.bm.rest_web_services.entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PersonRepository personRepository;

    public UserRepositoryCommandLineRunner(UserRepository userRepository, PersonRepository personRepository) {
        this.userRepository = userRepository;
        this.personRepository = personRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        userRepository.saveAll(
                List.of(
                        new User(
                                "Ahmed Samir",
                                LocalDate.of(1987, 3, 16)
                        ),
                        new User(
                                "Mahmoud Samir",
                                LocalDate.of(1994, 11, 17)
                        ),
                        new User(
                                "Mohamed Samir",
                                LocalDate.of(2005, 11, 23)
                        )
                )
        );

        personRepository.save(
                new Person("Ahmed", "Samir")
        );

    }
}
