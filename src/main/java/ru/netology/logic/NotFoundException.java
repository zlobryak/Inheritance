package ru.netology.logic;


public class NotFoundException extends RuntimeException {
  public NotFoundException(String msg) {
    super(msg);
  }
}

