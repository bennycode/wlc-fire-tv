package com.welovecoding.app.firetv.dummy;

/**
 * A dummy item representing a piece of content.
 */
public class DummyItem {

  public String id;
  public String content;

  public DummyItem(String id, String content) {
    this.id = id;
    this.content = content;
  }

  @Override
  public String toString() {
    return content;
  }
}
