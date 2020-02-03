package com.szczeppan.empik.services;

import com.szczeppan.empik.annotations.UserCounter;
import com.szczeppan.empik.model.domain.User;
import com.szczeppan.empik.model.github.GithubUser;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsersService {

  private final GithubService githubService;

  public UsersService(
      GithubService githubService) {
    this.githubService = githubService;
  }

  @Transactional
  @UserCounter
  public Optional<User> findUserDetails(String login) {
    return githubService.findUser(login).map(this::mapGithubUserToUser);
  }


  private User mapGithubUserToUser(GithubUser githubUser) {
    User user = new User();
    user.setId(githubUser.getId());
    user.setLogin(githubUser.getLogin());
    user.setName(githubUser.getName());
    user.setAvatarUrl(githubUser.getAvatarUrl());
    user.setType(githubUser.getType());
    user.setCreatedAt(githubUser.getCreatedAt());
    double calculations = getCalculations(githubUser);
    user.setCalculations(calculations);
    return user;
  }

  double getCalculations(GithubUser githubUser) {
    return 6.0 / githubUser.getFollowers() * (2.0 + githubUser.getPublicRepos());
  }
}
