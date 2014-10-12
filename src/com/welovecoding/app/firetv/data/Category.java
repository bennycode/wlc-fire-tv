package com.welovecoding.app.firetv.data;

import com.google.api.client.util.Key;

public class Category {

  @Key
  private int id;
  @Key
  private String name;
  @Key
  private String color;
  @Key
  private int numberOfVideos;

  public Category() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public int getNumberOfVideos() {
    return numberOfVideos;
  }

  public void setNumberOfVideos(int numberOfVideos) {
    this.numberOfVideos = numberOfVideos;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 47 * hash + this.id;
    hash = 47 * hash + (this.name != null ? this.name.hashCode() : 0);
    hash = 47 * hash + (this.color != null ? this.color.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Category other = (Category) obj;
    if (this.id != other.id) {
      return false;
    }
    if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
      return false;
    }
    if ((this.color == null) ? (other.color != null) : !this.color.equals(other.color)) {
      return false;
    }
    if (this.numberOfVideos != other.numberOfVideos) {
      return false;
    }
    return true;
  }

}
