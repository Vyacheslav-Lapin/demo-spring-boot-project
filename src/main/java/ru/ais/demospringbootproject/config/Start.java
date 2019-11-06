package ru.ais.demospringbootproject.config;

import java.util.Arrays;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import ru.ais.demospringbootproject.dao.CatRepository;
import ru.ais.demospringbootproject.model.Cat;

@Component
@RequiredArgsConstructor
public class Start implements ApplicationRunner {

  CatRepository catRepository;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    Arrays.stream("Васька,Мурка,Барсик".split(","))
        .map(Cat::new)
        .forEach(catRepository::save);
  }
}
