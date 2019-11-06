package ru.ais.demospringbootproject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.ais.demospringbootproject.HelloWorldTest.getExpectedPerson;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import ru.ais.demospringbootproject.model.UsualPerson;

@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = @Autowired)
//@ContextConfiguration("classpath:application-context.xml")
class SpringTCFAppTest {

  //todo 06.11.2019: сделать через Java-конфиг

	UsualPerson person;

  @Test
  void testInitPerson() {
		assertEquals(getExpectedPerson(), person);
	}

}
