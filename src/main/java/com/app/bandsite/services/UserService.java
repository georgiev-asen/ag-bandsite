package com.app.bandsite.services;

import com.app.bandsite.exceptions.UserExistsException;
import com.app.bandsite.model.dtos.RegisterUserDto;
import com.app.bandsite.model.entities.User;


public interface UserService {

  boolean validatePasswordMatch(RegisterUserDto registerUserDto);
  User registerNewUserAccount(RegisterUserDto accountDto) throws UserExistsException;
}
