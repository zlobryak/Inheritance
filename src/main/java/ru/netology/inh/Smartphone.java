package ru.netology.inh;
import java.util.Objects;

public class Smartphone extends Product {
  private String manufacturer;

  public Smartphone(int id, String name, int price, String manufacturer) {
    super(id, name, price);
    this.manufacturer = manufacturer;
  }
  public boolean matches(String search) {
    if (super.matches(search)) { // вызов метода matches в версии описанной в Product
      return true;
    }
    return Objects.equals(manufacturer, search);
  }
}
