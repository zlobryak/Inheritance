package ru.netology.inh;
import java.util.Objects;

public class Book extends Product {
    private String author;


    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        this.author = author;
    }
    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        return Objects.equals(author, search);
    }
}
