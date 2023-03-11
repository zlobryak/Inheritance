package ru.netology.logic;

public class AlreadyExistsException extends RuntimeException{
  public AlreadyExistsException(String msg) {
    super(msg);
  }
}
