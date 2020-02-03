package com.szczeppan.empik.transformers;

import com.szczeppan.empik.model.domain.User;
import com.szczeppan.empik.model.github.GithubUser;
import java.util.Optional;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Transformer;

@MessageEndpoint
public class GithubTransformer {

  @Transformer
  public Optional<User> transformUser(GithubUser githubUser) {
    if (githubUser == null) {
      return Optional.empty();
    }
    User user = new User();
    user.setId(githubUser.getId());
    user.setLogin(githubUser.getLogin());
    user.setName(githubUser.getName());
    user.setAvatarUrl(githubUser.getAvatarUrl());
    user.setType(githubUser.getType());
    user.setCreatedAt(githubUser.getCreatedAt());
    final double calculations = getCalculations(githubUser);
    user.setCalculations(calculations);
    return Optional.of(user);
  }

  double getCalculations(GithubUser githubUser) {
    return 6.0 / githubUser.getFollowers() * (2.0 + githubUser.getPublicRepos());
  }

}
