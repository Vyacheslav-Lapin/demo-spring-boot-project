package ru.ais.demospringbootproject;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.ais.demospringbootproject.model.Country;
import ru.ais.demospringbootproject.model.Customer;
import ru.ais.demospringbootproject.model.CustomerImpl;

@Ignore
class HelloWorldTest {

//  private static final String CONFIG = "application-context.xml";
//
//  BeanFactory context = new ClassPathXmlApplicationContext(CONFIG);
//
  static Customer getExpectedPerson() {
    return CustomerImpl.builder()
               .age(35)
               .name("John Smith")
               .country(new Country(1, "Russia", "RU"))
               .contact("222-33-22")
               .contact("kjhdsg@kjhsdf.ru")
               .build();
  }

//
//  @Test
//  @Ignore
//  public void testInitPerson() {
//    assertEquals(getExpectedPerson(), context.getBean("customer"));
//  }
}
