package com.szczeppan.empik.services;

import com.szczeppan.empik.model.domain.User;
import java.util.Optional;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface GithubService {

  @Gateway(requestChannel = "githubUserInput", replyChannel = "githubUserOutput")
  Optional<User> findUser(String login);
}
