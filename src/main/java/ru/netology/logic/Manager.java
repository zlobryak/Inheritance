package ru.netology.logic;

import ru.netology.inh.Product;

import static java.awt.SystemColor.text;

public class Manager {
    Repository repository;

    public void save(Product item){
        repository.save(item);
    }
    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {// "добавляем в конец" массива result продукт product
            }
        }
        return result;
    }
}
