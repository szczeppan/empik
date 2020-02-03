package com.szczeppan.empik.controllers;

import com.szczeppan.empik.exceptions.UserNotFoundException;
import com.szczeppan.empik.model.domain.User;
import com.szczeppan.empik.model.web.GetUserResponse;
import com.szczeppan.empik.services.UsersService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {

  private final UsersService usersService;

  public UsersController(UsersService usersService) {
    this.usersService = usersService;
  }

  @GetMapping("/{login}")
  public GetUserResponse findUser(@PathVariable String login) {
    User user = usersService.findUserDetails(login).orElseThrow(UserNotFoundException::new);
    return new GetUserResponse(user);
  }

}
