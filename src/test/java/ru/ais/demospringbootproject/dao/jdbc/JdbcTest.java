package ru.ais.demospringbootproject.dao.jdbc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import ru.ais.demospringbootproject.dao.CountryDao;
import ru.ais.demospringbootproject.model.Country;

//@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class JdbcTest {

//  CountryDao countryDao;
//
//  private List<Country> expectedCountryList = new ArrayList<>();
//  private List<Country> expectedCountryListStartsWithA = new ArrayList<Country>();
//  private Country countryWithChangedName = new Country(1, "Russia", "RU");
//
//  @Before
//  public void setUp() throws Exception {
//    initExpectedCountryLists();
//    countryDao.loadCountries();
//  }
//
//
//  @Test
//  @DirtiesContext
//  public void testCountryList() {
//    List<Country> countryList = countryDao.getCountryList();
//    assertNotNull(countryList);
//    assertEquals(expectedCountryList.size(), countryList.size());
//    for (int i = 0; i < expectedCountryList.size(); i++) {
//      assertEquals(expectedCountryList.get(i), countryList.get(i));
//    }
//  }
//
//  @Test
//  @DirtiesContext
//  public void testCountryListStartsWithA() {
//    List<Country> countryList = countryDao.getCountryListStartWith("A");
//    assertNotNull(countryList);
//    assertEquals(expectedCountryListStartsWithA.size(), countryList.size());
//    for (int i = 0; i < expectedCountryListStartsWithA.size(); i++) {
//      assertEquals(expectedCountryListStartsWithA.get(i), countryList.get(i));
//    }
//  }
//
//  @Test
//  @DirtiesContext
//  public void testCountryChange() {
//    countryDao.updateCountryName("RU", "Russia");
//    assertEquals(countryWithChangedName, countryDao.getCountryByCodeName("RU"));
//  }
//
//  private void initExpectedCountryLists() {
//    for (int i = 0; i < CountryDao.COUNTRY_INIT_DATA.length; i++) {
//      String[] countryInitData = CountryDao.COUNTRY_INIT_DATA[i];
//      Country country = new Country(i, countryInitData[0], countryInitData[1]);
//      expectedCountryList.add(country);
//      if (country.getName().startsWith("A")) {
//        expectedCountryListStartsWithA.add(country);
//      }
//    }
//  }
}
