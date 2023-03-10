package ru.netology.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import org.mockito.Mockito;

import static org.mockito.Mockito.*;

import ru.netology.inh.Book;
import ru.netology.inh.Product;
import ru.netology.inh.Smartphone;


class ManagerTest {
  Product item1 = new Book(1, "BookName", 1500, "AuthorName");
  Product item2 = new Smartphone(2, "SmartPhoneName", 25_000, "ManufacturerName");
  Product item3 = new Book(3, "BookName", 1560, "AuthorName");
  Product item4 = new Smartphone(4, "SmartPhoneName", 27_000, "ManufacturerName");


  @Test
  void FindAllManager() { //Получение всех сохраненных значений.
    Repository repository = Mockito.mock(Repository.class);
    Manager manager = new Manager(repository);
    Product[] repositoryMoc = {item1, item2};
    doReturn(repositoryMoc).when(repository).findAll();

    Product[] actual = manager.findAll();
    Assertions.assertArrayEquals(repositoryMoc, actual);
  }


  @Test
  void save() {
    Repository repository = new Repository();
    Manager manager = new Manager(repository);
    manager.save(item1);
    Product[] expected = {item1};
    Assertions.assertArrayEquals(expected, manager.findAll());
  }


  @Test
  void matchesTrue() { //Для совпадения при поиске
    Manager manager = new Manager();
    Assertions.assertTrue(manager.matches(item1, "BookName"));
  }

  @Test
  void matchesFalse() { //Для несовпадения при поиске
    Manager manager = new Manager();
    Assertions.assertFalse(manager.matches(item2, "BookName"));
  }

  @Test
  void searchByIfContainOne() { //Поиск, если есть 1 результат
    Repository repository = Mockito.mock(Repository.class);
    Manager manager = new Manager(repository);
    Product[] repositoryMoc = {item1, item2};
    doReturn(repositoryMoc).when(repository).findAll();
    Product[] expected = {item2};
    Product[] actual = manager.searchBy("SmartPhoneName");
    Assertions.assertArrayEquals(expected, actual);
  }
  @Test
  void searchByIfContainTwo() { //Поиск, если есть 2 результата
    Repository repository = Mockito.mock(Repository.class);
    Manager manager = new Manager(repository);
    Product[] repositoryMoc = {item1, item2, item3, item4};
    doReturn(repositoryMoc).when(repository).findAll();
    Product[] expected = {item2, item4};
    Product[] actual = manager.searchBy("SmartPhoneName");
    Assertions.assertArrayEquals(expected, actual);
  }
  @Test
  void searchByIfContainNone() { //Поиск, если нет результатов
    Repository repository = Mockito.mock(Repository.class);
    Manager manager = new Manager(repository);
    Product[] repositoryMoc = {item1, item2, item3, item4};
    doReturn(repositoryMoc).when(repository).findAll();
    Product[] expected = new Product[0];
    Product[] actual = manager.searchBy("NoResults");
    Assertions.assertArrayEquals(expected, actual);
  }
}