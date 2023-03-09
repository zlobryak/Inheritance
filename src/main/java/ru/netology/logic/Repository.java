package ru.netology.logic;

import ru.netology.inh.Product;

public class Repository {

    Product[] catalog = new Product[0];

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
        Product[] tmp = new Product[catalog.length - 1];
        int copyToIndex = 0;
        for (Product item : catalog) {
            if (item.getID() != id) {
                tmp[copyToIndex] = item;
                copyToIndex++;
            }
        }
        catalog = tmp;
    }
}
