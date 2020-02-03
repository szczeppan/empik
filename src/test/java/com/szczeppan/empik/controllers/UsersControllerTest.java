package com.szczeppan.empik.controllers;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.szczeppan.empik.exceptions.GithubException;
import com.szczeppan.empik.model.domain.User;
import com.szczeppan.empik.services.UsersService;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest
class UsersControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private UsersService usersService;

  @Test
  void findUser_shouldReturn200AndUser() throws Exception {
    final User user = new User();
    user.setLogin("login");
    when(usersService.findUserDetails("login")).thenReturn(Optional.of(user));

    mockMvc.perform(get("/users/login"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.login", is("login")));
  }

  @Test
  void findUser_shouldReturn404() throws Exception {
    when(usersService.findUserDetails("login")).thenReturn(Optional.empty());

    mockMvc.perform(get("/users/login"))
        .andExpect(status().isNotFound());
  }

  @Test
  void findUser_shouldReturn500() throws Exception {
    when(usersService.findUserDetails("login")).thenThrow(GithubException.class);

    mockMvc.perform(get("/users/login"))
        .andExpect(status().isInternalServerError());
  }

}
