package ru.ais.demospringbootproject.aop;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lombok.RequiredArgsConstructor;
import lombok.experimental.NonFinal;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.ais.demospringbootproject.commons.TestUtils;
import ru.ais.demospringbootproject.model.Bar;
import ru.ais.demospringbootproject.model.Customer;
import ru.ais.demospringbootproject.model.CustomerBrokenException;

@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class AopAspectJExceptionTest {

  Bar bar;

  Customer customer;

  @NonFinal
  String out;

  @BeforeEach
  public void setUp() {
    //        customer.setBroke(true);
    out = TestUtils.fromSystemOutPrintln(() -> bar.sellSquishee(customer));
  }

  @Test
  public void testAfterThrowingAdvice() {

    assertThrows(CustomerBrokenException.class, () -> bar.sellSquishee(customer));
    assertTrue("Customer is not broken ", out.contains("Hmmm..."));
  }
}
