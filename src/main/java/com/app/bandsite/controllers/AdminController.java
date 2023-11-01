package com.app.bandsite.controllers;

import com.app.bandsite.exceptions.UserExistsException;
import com.app.bandsite.model.dtos.UserDto;
import com.app.bandsite.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("admin")
public class AdminController {
  private final UserService userService;

  @Autowired
  public AdminController(UserService userService) {
    this.userService = userService;
  }


  @GetMapping
  public String adminIndex(){
    return "index";
  }

  @PostMapping("/register")
  public String register(@ModelAttribute("user") UserDto dto) throws UserExistsException {
    userService.registerNewUserAccount(dto);

    return "redirect:/admin";
  }

  @GetMapping("/register")
  public String loadRegisterPage(@ModelAttribute("user") UserDto user){
    return "register";
  }
}
