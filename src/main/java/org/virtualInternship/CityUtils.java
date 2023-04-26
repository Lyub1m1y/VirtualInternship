package org.virtualInternship;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CityUtils {

  public static void sortByCityName(List<City> cities) {
    if (cities != null) {
      Comparator<City> comparator = Comparator.comparing(city -> city.getName().toLowerCase());
      cities.sort(comparator);
    }
  }

  public static void sortByCityDistrictAndName(List<City> cities) {
    if (cities != null) {
      Comparator<City> comparator =
          Comparator.comparing(City::getDistrict).thenComparing(City::getName);
      cities.sort(comparator);
    }
  }

  public static int[] findCityWithMaxPopulation(List<City> cities) {
    if (cities == null) {
      return null;
    }

    int maxPopulation = 0;
    int maxPopulationIndex = 0;
    for (int i = 0; i < cities.size(); i++) {
      if (cities.get(i).getPopulation() > maxPopulation) {
        maxPopulation = cities.get(i).getPopulation();
        maxPopulationIndex = i;
      }
    }
    int[] max = {maxPopulation, maxPopulationIndex};
    return max;
  }

  public static Map<String, Integer> countCitiesByRegion(List<City> cities) {
    if (cities == null) {
      return null;
    }

    Map<String, Integer> result = new HashMap<>();
    for (City city : cities) {
      String region = city.getRegion();
      if (result.containsKey(region)) {
        result.put(region, result.get(region) + 1);
      } else {
        result.put(region, 1);
      }
    }
    return result;
  }
}
