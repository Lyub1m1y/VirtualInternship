package org.virtualInternship.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.virtualInternship.City;
import org.virtualInternship.CityUtils;
import org.virtualInternship.Main;

public class CityUtilsTest {

  @Test
  public void testSortByCityName() {
    List<City> expectedCities = new ArrayList<>();
    expectedCities.add(new City("Абаза", "Хакасия", "Сибирский", 17111, "1867"));
    expectedCities.add(new City("Абакан", "Хакасия", "Сибирский", 165183, "1931"));
    expectedCities.add(new City("Абдулино", "Оренбургская область", "Приволжский", 20663, "1795"));

    List<City> actualCities = Main.readCityData();
    CityUtils.sortByCityName(actualCities);

    for (int i = 0; i < 3; i++) {
      assertEquals(expectedCities.get(i), actualCities.get(i));
    }
  }

  @Test
  public void testSortByCityDistrictAndName() {
    List<City> expectedCities = new ArrayList<>();
    expectedCities.add(new City("Алдан", "Якутия", "Дальневосточный", 21277, "1924"));
    expectedCities.add(new City("Александровск-Сахалинский", "Сахалинская область",
        "Дальневосточный", 10613, "1869"));
    expectedCities.add(new City("Амурск", "Хабаровский край", "Дальневосточный", 42977, "1958"));

    List<City> actualCities = Main.readCityData();
    CityUtils.sortByCityDistrictAndName(actualCities);

    for (int i = 0; i < 3; i++) {
      assertEquals(expectedCities.get(i), actualCities.get(i));
    }
  }

  @Test
  public void testFindCityWithMaxPopulation() {
    List<City> cities = new ArrayList<>();
    cities.add(new City("Алдан", "Якутия", "Дальневосточный", 21277, "1924"));
    cities.add(new City("Агрыз", "Татарстан", "Приволжский", 19299, "1646"));
    cities.add(new City("Москва", "Москва", "Центральный", 11514330, "1147"));
    int[] expectedMax = new int[2];
    expectedMax[0] = 11514330;
    expectedMax[1] = 2;

    int[] actualMax = CityUtils.findCityWithMaxPopulation(cities);

    assertArrayEquals(expectedMax, actualMax);
  }

  @Test
  public void testFindCityWithMaxPopulationWithNullInput() {
    int[] max = CityUtils.findCityWithMaxPopulation(null);

    assertEquals(null, max);
  }

  @Test
  public void testCountCitiesByRegion() {
    List<City> cities = new ArrayList<>();
    cities.add(new City("Алдан1", "Якутия", "Дальневосточный", 21277, "1924"));
    cities.add(new City("Агрыз1", "Татарстан", "Приволжский", 19299, "1646"));
    cities.add(new City("Агрыз2", "Татарстан", "Приволжский", 19299, "1646"));
    cities.add(new City("Агрыз3", "Татарстан", "Приволжский", 19299, "1646"));
    cities.add(new City("Москва1", "Москва", "Центральный", 11514330, "1147"));
    cities.add(new City("Москва2", "Москва", "Центральный", 11514330, "1147"));

    Map<String, Integer> expectedMap = new HashMap<>();
    expectedMap.put("Якутия", 1);
    expectedMap.put("Татарстан", 3);
    expectedMap.put("Москва", 2);

    Map<String, Integer> actualMap = CityUtils.countCitiesByRegion(cities);

    assertEquals(expectedMap, actualMap);
  }

  @Test
  public void testCountCitiesByRegionWithNullInput() {
    Map<String, Integer> result = CityUtils.countCitiesByRegion(null);

    assertEquals(null, result);
  }
}
