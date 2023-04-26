package org.virtualInternship;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static final String file = "city_directory.csv";

  public static void main(String[] args) {
    List<City> cities = readCityData();
    if (cities != null) {
      int[] max = findCityWithMaxPopulation(cities);
      System.out.println("[" + max[1] + "] = " + max[0]);
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
          System.err.println("Invalid population value at line: " + scanner.nextLine());
        }
      }
      return cities;
    } catch (IOException | NullPointerException e) {
      System.err.println("An error occurred while working with the file: " + e.getMessage());
    }
    return null;
  }

  public static int[] findCityWithMaxPopulation(List<City> cities) {
    City[] citiesArray = cities.toArray(new City[cities.size()]);

    int[] max = new int[2]; // max[0] == maxPopulation, max[1] == maxPopulationIndex

    for (int i = 0; i < citiesArray.length; i++) {
      if (citiesArray[i].getPopulation() > max[0]) {
        max[0] = citiesArray[i].getPopulation();
        max[1] = i;
      }
    }
    return max;
  }
}
