package ru.netology.inh;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
  protected int id;
  protected String name;
  protected int price;


  public void setId(int id) {
    if (id > 0) {
      this.id = id;
    } else this.id = 0;
  }

  public void setPrice(int price) {
    if (price > 0) {
      this.price = price;
    } else this.price = 0;
  }
}
