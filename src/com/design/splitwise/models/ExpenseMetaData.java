package com.design.splitwise.models;

public class ExpenseMetaData {
  private String notes;
  private String name;
  private String imageUrl;

  ExpenseMetaData(String notes, String name, String imageUrl) {
    this.notes = notes;
    this.name = name;
    this.imageUrl = imageUrl;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }
}
