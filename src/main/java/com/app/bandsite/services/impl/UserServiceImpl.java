package com.app.bandsite.services.impl;

import com.app.bandsite.exceptions.UserExistsException;
import com.app.bandsite.model.dtos.UserDto;
import com.app.bandsite.model.entities.User;
import com.app.bandsite.model.enums.Role;
import com.app.bandsite.repositories.UserRepository;
import com.app.bandsite.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

  private final PasswordEncoder passwordEncoder;
  private final UserRepository userRepository;

  @Autowired
  public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository) {
    this.passwordEncoder = passwordEncoder;
    this.userRepository = userRepository;
  }

  @Override
  public User registerNewUserAccount(UserDto accountDto) throws UserExistsException {
    if (userRepository.existsById(accountDto.getUsername())) {
      throw new UserExistsException(
              "There is an account with that email adress:" + accountDto.getUsername());
    }
    User user = new User();
    user.setPassword(passwordEncoder.encode(accountDto.getPassword()));

    user.setUsername(accountDto.getUsername());
    user.setRoles(List.of(Role.ADMIN));
    return userRepository.save(user);
  }
}
