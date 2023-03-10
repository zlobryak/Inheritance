package ru.netology.inh;

public class Smartphone extends Product {

  private String manufacturer;

  public Smartphone(int id, String name, int price, String manufacturer) {
    super(id, name, price);
    this.manufacturer = manufacturer;
  }
}
