package ru.ais.demospringbootproject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.ais.demospringbootproject.model.Country;
import ru.ais.demospringbootproject.model.Customer;
import ru.ais.demospringbootproject.model.CustomerImpl;

@Configuration
public class TestConfig {

  @Bean
  Customer customer(Country country) {
    return CustomerImpl.builder()
               .age(35)
               .name("John Smith")
               .country(country)
               .contact("222-33-22")
               .contact("kjhdsg@kjhsdf.ru")
               .build();
  }

  @Bean
  Country country() {
    return Country.builder()
               .id(1)
               .name("Russia")
               .codeName("RU")
               .build();
  }
}
