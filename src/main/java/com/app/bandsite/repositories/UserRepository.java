package com.app.bandsite.repositories;

import com.app.bandsite.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {
  User findByPassword(String password);

  List<User> getByPassword(String password);

}
