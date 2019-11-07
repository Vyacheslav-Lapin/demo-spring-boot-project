package ru.ais.demospringbootproject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.ais.demospringbootproject.HelloWorldTest.getExpectedPerson;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.ais.demospringbootproject.model.Person;

@SpringBootTest//(classes = TestConfig.class)
@RequiredArgsConstructor(onConstructor_ = @Autowired)
//@ContextConfiguration("classpath:application-context.xml")
class SpringTCFAppTest {

	Person person;

  @Test
  void testInitPerson() {
		assertEquals(getExpectedPerson(), person);
	}

}
