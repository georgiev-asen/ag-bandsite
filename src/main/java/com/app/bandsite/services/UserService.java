package com.app.bandsite.services;

import com.app.bandsite.exceptions.UserExistsException;
import com.app.bandsite.model.dtos.UserDto;
import com.app.bandsite.model.entities.User;


public interface UserService {

  User registerNewUserAccount(UserDto accountDto) throws UserExistsException;
}
