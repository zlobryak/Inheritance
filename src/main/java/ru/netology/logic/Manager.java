package ru.netology.logic;

import ru.netology.inh.Product;


public class Manager {
  public Manager(Repository repository) {
    this.repository = repository;
  }

  private Repository repository;

  public void save(Product item) {
    repository.save(item);
  }

  public Product[] findAll() {
    return repository.findAll();
  }

//  public boolean matches(Product product, String search) {
//    if (product.getName().contains(search)) {
//      return true;
//    } else {
//      return false;
//    }
//  }

  public Product[] searchBy(String text) {
    Product[] result = new Product[0];
    for (Product product : repository.findAll()) {
      if (product.matches(text)) {
        Product[] tmp = new Product[result.length + 1];
        for (int i = 0; i < result.length; i++) {
          tmp[i] = result[i];
        }
        tmp[tmp.length - 1] = product;
        result = tmp;
      }
    }
    return result;
  }
}
