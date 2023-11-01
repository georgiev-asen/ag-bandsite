package com.app.bandsite.exceptions;

public class UserExistsException extends Exception{
  public UserExistsException(String errorMessage) {
    super(errorMessage);
  }
}
