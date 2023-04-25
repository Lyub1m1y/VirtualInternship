package org.virtualInternship.test;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.virtualInternship.City;
import org.virtualInternship.Main;

public class ReadCityDataTest {

  @Test
  public void testReadCityData() {
    List<City> expectedCities = new ArrayList<>();
    expectedCities.add(new City("Адыгейск", "Адыгея", "Южный", 12248, "1973"));
    expectedCities.add(new City("Майкоп", "Адыгея", "Южный", 144246, "1857"));
    expectedCities.add(new City("Горно-Алтайск", "Алтай", "Сибирский", 56928, "1830"));

    List<City> actualCities = Main.readCityData();
    for (int i = 0; i < 3; i++) {
      Assert.assertEquals(expectedCities.get(i), actualCities.get(i));
    }

  }

}
