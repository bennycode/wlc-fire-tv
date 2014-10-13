package com.welovecoding.app.firetv.data;

import com.google.api.client.util.Key;
import java.util.List;

public class CategoryResult {

  @Key
  private List<Category> categories;

  public CategoryResult() {
  }

  public List<Category> getCategories() {
    return categories;
  }

  public void setCategories(List<Category> categories) {
    this.categories = categories;
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 29 * hash + (this.categories != null ? this.categories.hashCode() : 0);
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
    final CategoryResult other = (CategoryResult) obj;
    if (this.categories != other.categories && (this.categories == null || !this.categories.equals(other.categories))) {
      return false;
    }
    return true;
  }

}
