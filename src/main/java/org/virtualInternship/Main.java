package org.virtualInternship;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

  public static final String file = "city_directory.csv";

  public static void main(String[] args) {
    List<City> cities = readCityData();
    if (cities != null) {
      Map<String, Integer> citiesByRegion = CityUtils.countCitiesByRegion(cities);

      // print citiesByRegion
      for (Map.Entry<String, Integer> entry : citiesByRegion.entrySet()) {
        System.out.println(entry.getKey() + " - " + entry.getValue());
      }
    } else {
      System.out.println("Error! The readCityData method returned null");
    }
  }

  public static List<City> readCityData() {
    try (InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(file);
        Scanner scanner = new Scanner(inputStream)) {
      List<City> cities = new ArrayList<>();
      while (scanner.hasNext()) {
        String currentLine = scanner.nextLine();
        String[] cityData = currentLine.split(";");
        if (cityData.length < 6) {
          System.err.println("Missing city data at line: " + currentLine);
          continue;
        }
        try {
          City city = new City(cityData[1], cityData[2], cityData[3], Integer.parseInt(cityData[4]),
              cityData[5]);
          cities.add(city);
        } catch (NumberFormatException e) {
          System.err.println("Invalid population value at line: " + currentLine);
        }
      }
      return cities;
    } catch (IOException | NullPointerException e) {
      System.err.println("An error occurred while working with the file: " + e.getMessage());
    }
    return null;
  }
}
