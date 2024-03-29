package ru.ais.demospringbootproject.commons;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Consumer;
import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.val;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public interface TestUtils {

  String LINE_SEPARATOR = System.lineSeparator();
  String TEST_RESOURCES_PATH = "./src/test/resources/";

  @NotNull
  @Contract(pure = true)
  static String fromPrintStream(@NotNull Consumer<PrintStream> printStreamConsumer) {
    val out = new ByteArrayOutputStream();
    @Cleanup val printStream = new PrintStream(out);
    printStreamConsumer.accept(printStream);
    return new String(out.toByteArray()).intern();
  }

  @NotNull
  @SneakyThrows
  @Contract(value = "_ -> new", pure = true)
  static String fromSystemOutPrint(@NotNull Runnable task) {
    return fromPrintStream(printStream -> {
      PrintStream realOut = System.out;
      System.setOut(printStream);
      task.run();
      System.setOut(realOut);
    });
  }

  @NotNull
  @Contract(pure = true)
  static String fromSystemOutPrintln(@NotNull Runnable runnable) {
    String s = fromSystemOutPrint(runnable);
    return s.endsWith(LINE_SEPARATOR) ?
             s.substring(0, s.length() - LINE_SEPARATOR.length()) :
             s;
  }

  @NotNull
  @Contract(pure = true)
  @SuppressWarnings("unused")
  static String toTestResourceFilePath(@NotNull String fileName) {
    return TEST_RESOURCES_PATH + fileName;
  }
}
