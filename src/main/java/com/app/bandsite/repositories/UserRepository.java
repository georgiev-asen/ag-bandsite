package com.app.bandsite.repositories;

import com.app.bandsite.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
