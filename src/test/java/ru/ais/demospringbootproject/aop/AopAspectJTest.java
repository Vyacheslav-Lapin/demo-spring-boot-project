package ru.ais.demospringbootproject.aop;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import lombok.RequiredArgsConstructor;
import lombok.experimental.NonFinal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.ais.demospringbootproject.commons.TestUtils;
import ru.ais.demospringbootproject.model.ApuBar;
import ru.ais.demospringbootproject.model.Bar;
import ru.ais.demospringbootproject.model.Customer;

@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class AopAspectJTest {

  Bar bar;

  Customer customer;

  @NonFinal
  String out;

  @BeforeEach
  public void setUp() {
    out = TestUtils.fromSystemOutPrintln(() -> bar.sellSquishee(customer));

    System.out.println(out);
  }

  @Test
  public void testBeforeAdvice() {
    assertTrue("Before advice is not good enought...", out.contains("Hello"));
    assertTrue("Before advice is not good enought...", out.contains("How are you doing?"));
  }

  @Test
  public void testAfterAdvice() {
    assertTrue("After advice is not good enought...", out.contains("Good Bye!"));
  }

  @Test
  public void testAfterReturningAdvice() {
    assertTrue("Customer is broken", out.contains("Good Enough?"));
  }

  @Test
  public void testAroundAdvice() {
    assertTrue("Around advice is not good enought...", out.contains("Hi!"));
    assertTrue("Around advice is not good enought...", out.contains("See you!"));
  }

  @Test
  public void testAllAdvices() {
    assertTrue("barObject instanceof ApuBar",
        bar instanceof ApuBar);
  }
}
