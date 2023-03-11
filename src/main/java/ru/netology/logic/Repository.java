package ru.netology.logic;

import ru.netology.inh.Product;

public class Repository {
  private Product[] catalog = new Product[0];

  public void save(Product item) {
    if (findById(item.getId()) == null) {
      Product[] tmp = new Product[catalog.length + 1];
      for (int i = 0; i < catalog.length; i++) {
        tmp[i] = catalog[i];
      }
      tmp[tmp.length - 1] = item;
      catalog = tmp;
    } else {
      throw new AlreadyExistsException("Element " + item.getName() + "already exists");
    }
  }

  public Product[] findAll() {
    return catalog;
  }

  public void removeById(int id) {
    if (findById(id) != null) {
      Product[] tmp = new Product[catalog.length - 1];
      int copyToIndex = 0;
      for (Product itemCounter : catalog) {
        if (itemCounter.getId() != id) {
          tmp[copyToIndex] = itemCounter;
          copyToIndex++;
        }
        catalog = tmp;
      }
    } else {
      throw new NotFoundException("Element with id:" + id + "is not found.");
    }
  }

  public Product findById(int id) {
    for (Product product : catalog) {
      if (product.getId() == id) {
        return product;
      }
    }
    return null;
  }
}
