package ru.netology.logic;

import ru.netology.inh.Product;


public class Manager {
  private Repository repository = new Repository();

  public Manager() {

  }

  public Manager(Repository repository) {
    this.repository = repository;
  }


  public void save(Product item) {
    repository.save(item);
  }

  public Product[] findAll() {
    return repository.findAll();
  }

  public boolean matches(Product product, String search) {
    return product.getName().contains(search);
  }

  public Product[] searchBy(String text) {
    Product[] result = new Product[0];
    for (Product product : repository.findAll()) {
      if (matches(product, text)) {
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
