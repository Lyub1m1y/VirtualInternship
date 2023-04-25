package org.virtualInternship.test;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.virtualInternship.City;
import org.virtualInternship.Main;

public class CityTest {

  @Test
  public void testCityToString() {
    String expectedStr1 =
        "City{name='Адыгейск', region='Адыгея', district='Южный', population=12248, foundation='1973'}";
    String expectedStr2 =
        "City{name='Майкоп', region='Адыгея', district='Южный', population=144246, foundation='1857'}";
    String expectedStr3 =
        "City{name='Горно-Алтайск', region='Алтай', district='Сибирский', population=56928, foundation='1830'}";

    List<City> actualCities = Main.readCityData();
    Assert.assertEquals(expectedStr1, actualCities.get(0).toString());
    Assert.assertEquals(expectedStr2, actualCities.get(1).toString());
    Assert.assertEquals(expectedStr3, actualCities.get(2).toString());
  }
}
