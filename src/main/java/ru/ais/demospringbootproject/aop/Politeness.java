package ru.ais.demospringbootproject.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.jetbrains.annotations.NotNull;
import ru.ais.demospringbootproject.model.Customer;
import ru.ais.demospringbootproject.model.Squishee;

@Aspect
public class Politeness {

  @Before("execution(* sellSquishee(..))")
  public void sayHello(@NotNull JoinPoint joinPiont) {
    System.out.printf("Hello %s. How are you doing?\n", ((Customer) joinPiont.getArgs()[0]).getName());
  }

  @AfterReturning(
      pointcut = "execution(* sellSquishee(..))",
      returning = "retVal",
      argNames = "retVal")
  public void askOpinion(Object retVal) {
    System.out.printf("Is %s Good Enough?\n", ((Squishee) retVal).getName());
  }

  public void sayYouAreNotAllowed() {
    System.out.println("Hmmm...");
  }

  public void sayGoodBye() {
    System.out.println("Good Bye!");
  }

  public Object sayPoliteWordsAndSell(@NotNull ProceedingJoinPoint pjp) throws Throwable {
    System.out.println("Hi!");
    Object retVal = pjp.proceed();
    System.out.println("See you!");
    return retVal;
  }

}
