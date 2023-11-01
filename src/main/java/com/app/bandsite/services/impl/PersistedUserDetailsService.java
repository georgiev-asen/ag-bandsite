package com.app.bandsite.services.impl;

import com.app.bandsite.model.entities.User;
import com.app.bandsite.model.enums.Role;
import com.app.bandsite.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PersistedUserDetailsService implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<User> userQuery = userRepository.findById(username);
    if (userQuery.isEmpty()) {
      throw new UsernameNotFoundException("No user found with username: " + username);
    }

    User user = userQuery.get();

    boolean enabled = true;
    boolean accountNonExpired = true;
    boolean credentialsNonExpired = true;
    boolean accountNonLocked = true;

    return new org.springframework.security.core.userdetails.User(
            user.getUsername(), user.getPassword(), enabled, accountNonExpired,
            credentialsNonExpired, accountNonLocked, getAuthorities(user.getRoles()));
  }

  private static List<GrantedAuthority> getAuthorities (List<Role> roles) {
    List<GrantedAuthority> authorities = new ArrayList<>();
    for (Role role : roles) {
      authorities.add(new SimpleGrantedAuthority(role.name()));
    }
    return authorities;
  }
}
