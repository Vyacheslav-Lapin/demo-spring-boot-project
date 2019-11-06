package ru.ais.demospringbootproject;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.ais.demospringbootproject.model.Country;
import ru.ais.demospringbootproject.model.Person;
import ru.ais.demospringbootproject.model.PersonImpl;

class HelloWorldTest {

  private static final String CONFIG = "application-context.xml";

  AbstractApplicationContext context = new ClassPathXmlApplicationContext(CONFIG);

  static Person getExpectedPerson() {
    return PersonImpl.builder()
               .age(35)
               .name("John Smith")
               .country(new Country(1, "Russia", "RU"))
               .contact("222-33-22")
               .contact("kjhdsg@kjhsdf.ru")
               .build();
  }

  @Test
  public void testInitPerson() {
    assertEquals(getExpectedPerson(), context.getBean("person"));
  }
}
