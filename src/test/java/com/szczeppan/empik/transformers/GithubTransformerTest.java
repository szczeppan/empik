package com.szczeppan.empik.transformers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.szczeppan.empik.model.domain.User;
import com.szczeppan.empik.model.github.GithubUser;
import java.time.LocalDateTime;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GithubTransformerTest {

  @InjectMocks
  private GithubTransformer githubTransformer;

  @Test
  void transformUser_shouldReturnOptionalEmptyOnNull() {
    final Optional<User> user = githubTransformer.transformUser(null);

    assertTrue(user.isEmpty());
  }

  @Test
  void transformUser_shouldConvertGithubUserToUser() {
    final GithubUser githubUser = new GithubUser();
    githubUser.setAvatarUrl("avatarUrl");
    githubUser.setCreatedAt(LocalDateTime.now());
    githubUser.setId(1L);
    githubUser.setLogin("login");
    githubUser.setName("name");
    githubUser.setType("type");

    final Optional<User> optional = githubTransformer.transformUser(githubUser);

    assertTrue(optional.isPresent());
    final User user = optional.get();
    assertEquals(githubUser.getAvatarUrl(), user.getAvatarUrl());
    assertEquals(githubUser.getCreatedAt(), user.getCreatedAt());
    assertEquals(githubUser.getId(), user.getId());
    assertEquals(githubUser.getLogin(), user.getLogin());
    assertEquals(githubUser.getName(), user.getName());
    assertEquals(githubUser.getType(), user.getType());
  }

  @Test
  void getCalculations_shouldReturn18() {
    final GithubUser githubUser = new GithubUser();
    githubUser.setFollowers(1);
    githubUser.setPublicRepos(1);

    final double calculations = githubTransformer.getCalculations(githubUser);
    assertEquals(18, calculations);
  }

  @Test
  void getCalculations_shouldReturnInfinity() {
    final GithubUser githubUser = new GithubUser();
    githubUser.setFollowers(0);
    githubUser.setPublicRepos(1);

    final double calculations = githubTransformer.getCalculations(githubUser);
    assertEquals(Double.POSITIVE_INFINITY, calculations);
  }

}
