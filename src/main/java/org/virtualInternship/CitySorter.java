package org.virtualInternship;

import java.util.Comparator;
import java.util.List;

public class CitySorter {

  public static void sortByCityName(List<City> cities) {
    Comparator<City> comparator = Comparator.comparing(city -> city.getName().toLowerCase());
    cities.sort(comparator);
  }

  public static void sortByCityDistrictAndName(List<City> cities) {
    Comparator<City> comparator =
        Comparator.comparing(City::getDistrict).thenComparing(City::getName);
    cities.sort(comparator);
  }
}
