package ru.ais.demospringbootproject;

import static com.jayway.jsonpath.JsonPath.parse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.hateoas.MediaTypes.HAL_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.jayway.jsonpath.JsonPath;
import java.util.Arrays;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.MediaTypes;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.ais.demospringbootproject.dao.CatRepository;
import ru.ais.demospringbootproject.model.Cat;

@SpringBootTest
@AutoConfigureMockMvc
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@WithMockUser(authorities = "ADMIN")
class DemoSpringBootProjectApplicationTests {

  MockMvc mockMvc;

  CatRepository catRepository;

  @Test
  void contextLoads() {
  }

  @Test
  @SneakyThrows
  @DisplayName("cats method works correctly")
  void getCats() {
    mockMvc.perform(get("/cats"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(HAL_JSON_VALUE))
        .andExpect(mvcResult -> assertEquals(3,
            parse(mvcResult.getResponse().getContentAsString())
                .<Integer>read("$.page.totalElements").intValue()));
  }
}
