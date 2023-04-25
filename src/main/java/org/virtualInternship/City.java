package org.virtualInternship;

import java.util.Objects;

public class City {

  private String name;
  private String region;
  private String district;
  private int population;
  private String foundation;

  public City(String name, String region, String district, int population, String foundation) {
    this.name = name;
    this.region = region;
    this.district = district;
    this.population = population;
    this.foundation = foundation;
  }

  public String getName() {
    return name;
  }


  public String getRegion() {
    return region;
  }


  public String getDistrict() {
    return district;
  }


  public int getPopulation() {
    return population;
  }


  public String getFoundation() {
    return foundation;
  }


  public void setName(String name) {
    this.name = name;
  }


  public void setRegion(String region) {
    this.region = region;
  }


  public void setDistrict(String district) {
    this.district = district;
  }


  public void setPopulation(int population) {
    this.population = population;
  }


  public void setFoundation(String foundation) {
    this.foundation = foundation;
  }

  @Override
  public String toString() {
    return "City{" + "name='" + name + '\'' + ", region='" + region + '\'' + ", district='"
        + district + '\'' + ", population=" + population + ", foundation='" + foundation + '\''
        + '}';
  }

  @Override
  public int hashCode() {
    return Objects.hash(district, foundation, name, population, region);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }

    City other = (City) obj;
    return Objects.equals(district, other.district) && Objects.equals(foundation, other.foundation)
        && Objects.equals(name, other.name) && population == other.population
        && Objects.equals(region, other.region);
  }
}
