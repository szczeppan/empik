package com.szczeppan.empik.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import com.szczeppan.empik.apis.GithubApi;
import com.szczeppan.empik.exceptions.GithubException;
import com.szczeppan.empik.model.github.GithubUser;
import feign.FeignException;
import feign.FeignException.FeignClientException;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GithubServiceTest {

  @Mock
  private GithubApi githubApi;

  @InjectMocks
  private GithubService githubService;

  @Test
  void findUser_shouldReturnUser() {
    final GithubUser user = new GithubUser();
    user.setLogin("login");
    when(githubApi.getUser("login")).thenReturn(user);

    final Optional<GithubUser> githubUser = githubService.findUser("login");

    assertTrue(githubUser.isPresent());
    assertEquals("login", githubUser.map(GithubUser::getLogin).get());
  }

  @Test
  void findUser_shouldReturnEmptyWhenThrownFeignExceptionNotFound() {
    when(githubApi.getUser(anyString())).thenThrow(FeignException.NotFound.class);

    final Optional<GithubUser> githubUser = githubService.findUser("login");

    assertTrue(githubUser.isEmpty());
  }

  @Test
  void findUser_shouldThrowGithubExceptionOnAnyFeignClientException() {
    when(githubApi.getUser(anyString())).thenThrow(FeignClientException.class);

    assertThrows(GithubException.class,
        () -> githubService.findUser("login"));
  }
}
