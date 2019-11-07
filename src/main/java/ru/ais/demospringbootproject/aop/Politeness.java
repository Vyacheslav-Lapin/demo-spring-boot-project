package ru.ais.demospringbootproject.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ru.ais.demospringbootproject.model.Customer;
import ru.ais.demospringbootproject.model.CustomerBrokenException;
import ru.ais.demospringbootproject.model.Squishee;

@Aspect
@Component
public class Politeness {

  @Pointcut("execution(* ru.ais.demospringbootproject.model.ApuBar.sellSquishee(..))")
  public final void sellSquishee() {
  }

  @Before("sellSquishee()")
  public void sayHello(@NotNull JoinPoint joinPoint) {
    System.out.printf("Hello %s. How are you doing?\n", ((Customer) joinPoint.getArgs()[0]).getName());
  }

//  @Order(1)
  @AfterReturning(
      pointcut = "sellSquishee()",
      returning = "retVal",
      argNames = "retVal")
  public void askOpinion(Object retVal) {
    System.out.printf("Is %s Good Enough?\n", ((Squishee) retVal).getName());
  }

  @AfterThrowing(pointcut = "sellSquishee()", throwing = "ex")
  public void sayYouAreNotAllowed(@NotNull CustomerBrokenException ex) {
    System.out.println("Hmmm... " + ex.getClass().getSimpleName());
  }

  @After("sellSquishee()")
//  @Order(0)
  public void sayGoodBye() {
    System.out.println("Good Bye!");
  }

  @Around("sellSquishee()")
  public Object sayPoliteWordsAndSell(@NotNull ProceedingJoinPoint pjp) throws Throwable {
    System.out.println("Hi!");
    Object retVal = pjp.proceed();
    System.out.println("See you!");
    return retVal;
  }

}
