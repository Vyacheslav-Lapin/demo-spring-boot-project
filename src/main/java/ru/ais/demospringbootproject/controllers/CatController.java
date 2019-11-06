package ru.ais.demospringbootproject.controllers;

import javax.annotation.PostConstruct;
import javax.websocket.server.PathParam;
import lombok.SneakyThrows;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatController {

  @SneakyThrows
  @PostConstruct
  public final void init() {
    System.out.println("Я проинициализирован!");
  }

  @SneakyThrows
  @Contract(pure = true)
  @GetMapping(path = "/cat/{x}", produces = "application/json")
  public final @NotNull String method(@PathVariable int x) {
    return "{ \"hjgsdf\": " + x + "}";
  }

}
