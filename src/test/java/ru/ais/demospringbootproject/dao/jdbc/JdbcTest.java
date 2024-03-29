package ru.ais.demospringbootproject.dao.jdbc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import ru.ais.demospringbootproject.dao.CountryDao;
import ru.ais.demospringbootproject.model.Country;

@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class JdbcTest {

  CountryDao countryDao;

  private List<Country> expectedCountryList = new ArrayList<>();
  private List<Country> expectedCountryListStartsWithA = new ArrayList<Country>();
  private Country countryWithChangedName = new Country(8, "Russia", "RU");

  @BeforeEach
  public void setUp() throws Exception {
    initExpectedCountryLists();
    countryDao.loadInitData();
  }


  @Test
  @DirtiesContext
  public void testCountryList() {
    List<Country> countryList = countryDao.get();
    assertNotNull(countryList);
    assertEquals(expectedCountryList.size(), countryList.size());
    for (int i = 0; i < expectedCountryList.size(); i++) {
      assertEquals(expectedCountryList.get(i), countryList.get(i));
    }
  }

  @Test
  @DirtiesContext
  public void testCountryListStartsWithA() {
    List<Country> countryList = countryDao.getStartWith("A");
    assertNotNull(countryList);
    assertEquals(expectedCountryListStartsWithA.size(), countryList.size());
    for (int i = 0; i < expectedCountryListStartsWithA.size(); i++) {
      assertEquals(expectedCountryListStartsWithA.get(i), countryList.get(i));
    }
  }

  @Test
  @DirtiesContext
  public void testCountryChange() {
    countryDao.updateName("RU", "Russia");
    assertEquals(countryWithChangedName, countryDao.getByCodeName("RU"));
  }

  private void initExpectedCountryLists() {
    for (int i = 0; i < CountryDao.COUNTRY_INIT_DATA.length; i++) {
      String[] countryInitData = CountryDao.COUNTRY_INIT_DATA[i];
      Country country = new Country(i + 1, countryInitData[0], countryInitData[1]);
      expectedCountryList.add(country);
      if (country.getName().startsWith("A")) {
        expectedCountryListStartsWithA.add(country);
      }
    }
  }
}
