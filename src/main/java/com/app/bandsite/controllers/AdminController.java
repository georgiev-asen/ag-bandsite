package com.app.bandsite.controllers;

import com.app.bandsite.exceptions.UserExistsException;
import com.app.bandsite.model.dtos.RegisterUserDto;
import com.app.bandsite.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    return "redirect:/home";
  }

  @PostMapping("/register")
  public String register(@ModelAttribute @Valid RegisterUserDto registerUserDto, BindingResult bindingResult, Model model) throws UserExistsException {

    if (bindingResult.hasErrors()) {
      return "register";
    }

    boolean passwordMatchError = !userService.validatePasswordMatch(registerUserDto);

    if (passwordMatchError) {
      model.addAttribute("passwordMatchError", true);
      return "register";
    }

    userService.registerNewUserAccount(registerUserDto);

    return "redirect:/admin";
  }

  @GetMapping("/register")
  public String loadRegisterPage(@ModelAttribute RegisterUserDto registerUserDto){
    return "register";
  }

  @ExceptionHandler({ UserExistsException.class })
  public String handleUserExistsException(RedirectAttributes redirectAttributes) {
    redirectAttributes.addFlashAttribute("userExistsError", true);

    return "redirect:/admin/register";
  }
}
