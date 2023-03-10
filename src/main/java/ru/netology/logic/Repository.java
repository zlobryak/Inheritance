package ru.netology.logic;

import ru.netology.inh.Product;

public class Repository {
  private Product[] catalog = new Product[0];

  public void save(Product item) {
    Product[] tmp = new Product[catalog.length + 1];
    for (int i = 0; i < catalog.length; i++) {
      tmp[i] = catalog[i];
    }
    tmp[tmp.length - 1] = item;
    catalog = tmp;
  }

  public Product[] findAll() {
    return catalog;
  }

  public void removeById(int id) {
    for (Product item : catalog) {
      if (item.getId() == id) {
        Product[] tmp = new Product[catalog.length - 1];
        int copyToIndex = 0;
        for (Product itemCounter : catalog) {
          if (itemCounter.getId() != id) {
            tmp[copyToIndex] = itemCounter;
            copyToIndex++;
          }
        }
        catalog = tmp;
        break;
      }
    }
  }
}
