package ru.ais.demospringbootproject.config;

import java.util.Arrays;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.ais.demospringbootproject.dao.CatRepository;
import ru.ais.demospringbootproject.model.Cat;

@Configuration
public class Db {

  @Bean
  ApplicationRunner runner(CatRepository catRepository) {
    return __ -> Arrays.stream(
        "Васька,Мурка,Барсик"
            .split(","))
                     .map(Cat::new)
                     .forEach(catRepository::save);
  }
}
