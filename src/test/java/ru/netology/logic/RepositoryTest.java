package ru.netology.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.inh.Book;
import ru.netology.inh.Product;
import ru.netology.inh.Smartphone;


class RepositoryTest {
  Repository repository = new Repository();
  Product item1 = new Book(1, "BookName", 1500, "AuthorName");
  Product item2 = new Smartphone(2, "SmartPhoneName", 25_000, "ManufacturerName");

  @BeforeEach
  public void setup() {
    repository.save(item1);
    repository.save(item2);
  }

  @Test
  void saveAndFindAll() {
    Product item3 = new Product(1, "TestProduct", 1_000);
    repository.save(item3);

    Product[] expected = {item1, item2, item3};
    Assertions.assertArrayEquals(expected, repository.findAll());
  }

  @Test
  void removeByIdTest() { // Удаление по id
    repository.removeById(2);
    Product[] expected = {item1};
    Assertions.assertArrayEquals(expected, repository.findAll());
  }

  @Test
  public void removeByIdWhenWrongTest() {
    Assertions.assertThrows(NotFoundException.class, () -> {
      repository.removeById(-100);
    });
  }
}