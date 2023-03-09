package ru.netology.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.inh.Book;
import ru.netology.inh.Product;
import ru.netology.inh.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {
    @BeforeEach
    public void setup() {
        Repository repository = new Repository();
        Product item1 = new Book(1, "BookName", 1500, "AuthorName");
        Product item2 = new Smartphone(2, "SmartPhoneName", 25_000, "ManufacturerName");
        repository.save(item1);
        repository.save(item2);
    }

    @Test
    void findAll() {
    }

    @Test
    void removeById() {
    }
}