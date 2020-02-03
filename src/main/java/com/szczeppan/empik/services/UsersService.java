package com.szczeppan.empik.services;

import com.szczeppan.empik.annotations.UserCounter;
import com.szczeppan.empik.model.domain.User;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsersService {

  private final GithubService githubService;

  public UsersService(GithubService githubService) {
    this.githubService = githubService;
  }

  @Transactional
  @UserCounter
  public Optional<User> findUserDetails(String login) {
    return githubService.findUser(login);
  }
}
