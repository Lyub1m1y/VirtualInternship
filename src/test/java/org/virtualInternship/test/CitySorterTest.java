package org.virtualInternship.test;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.virtualInternship.City;
import org.virtualInternship.CitySorter;
import org.virtualInternship.Main;


public class CitySorterTest {

  @Test
  public void testSortByCityName() {
    List<City> expectedCities = new ArrayList<>();
    expectedCities.add(new City("Абаза", "Хакасия", "Сибирский", 17111, "1867"));
    expectedCities.add(new City("Абакан", "Хакасия", "Сибирский", 165183, "1931"));
    expectedCities.add(new City("Абдулино", "Оренбургская область", "Приволжский", 20663, "1795"));

    List<City> actualCities = Main.readCityData();
    CitySorter.sortByCityName(actualCities);

    for (int i = 0; i < 3; i++) {
      Assert.assertEquals(expectedCities.get(i), actualCities.get(i));
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
    CitySorter.sortByCityDistrictAndName(actualCities);

    for (int i = 0; i < 3; i++) {
      Assert.assertEquals(expectedCities.get(i), actualCities.get(i));
    }
  }
}
