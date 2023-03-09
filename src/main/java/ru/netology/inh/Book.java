package ru.netology.inh;

public class Book extends Product {
    String author;

    public Book(int ID, String name, int price, String author) {
        super(ID, name, price);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
