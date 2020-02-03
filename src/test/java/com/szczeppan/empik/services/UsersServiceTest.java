package com.szczeppan.empik.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import com.szczeppan.empik.model.domain.User;
import com.szczeppan.empik.model.github.GithubUser;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UsersServiceTest {

  @Mock
  private GithubService githubService;

  @InjectMocks
  private UsersService usersService;

  @Test
  void findUserDetails_shouldReturnEmptyIfLoginNotFound() {
    when(githubService.findUser("login")).thenReturn(Optional.empty());

    final Optional<User> login = usersService.findUserDetails("login");

    assertTrue(login.isEmpty());
  }
  @Test
  void findUserDetails_shouldReturnUser() {
    final GithubUser githubUser = new GithubUser();
    githubUser.setLogin("login");
    when(githubService.findUser("login")).thenReturn(Optional.of(githubUser));

    final Optional<User> login = usersService.findUserDetails("login");

    assertTrue(login.isPresent());
    assertEquals(githubUser.getLogin(), login.map(User::getLogin).get());
  }

}
