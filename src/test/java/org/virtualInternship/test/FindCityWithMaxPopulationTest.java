package org.virtualInternship.test;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.virtualInternship.City;
import org.virtualInternship.Main;

public class FindCityWithMaxPopulationTest {

  @Test
  public void testFindCityWithMaxPopulation() {
    List<City> cities = new ArrayList<>();
    cities.add(new City("Алдан", "Якутия", "Дальневосточный", 21277, "1924"));
    cities.add(new City("Агрыз", "Татарстан", "Приволжский", 19299, "1646"));
    cities.add(new City("Москва", "Москва", "Центральный", 11514330, "1147"));
    int[] expectedMax = new int[2];
    expectedMax[0] = 11514330;
    expectedMax[1] = 2;

    int[] actualMax = Main.findCityWithMaxPopulation(cities);

    Assert.assertArrayEquals(expectedMax, actualMax);

  }
}
