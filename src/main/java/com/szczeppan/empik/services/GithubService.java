package com.szczeppan.empik.services;

import com.szczeppan.empik.apis.GithubApi;
import com.szczeppan.empik.exceptions.GithubException;
import com.szczeppan.empik.model.github.GithubUser;
import feign.FeignException;
import feign.FeignException.FeignClientException;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class GithubService {

  private final GithubApi githubApi;

  public GithubService(GithubApi githubApi) {
    this.githubApi = githubApi;
  }

  public Optional<GithubUser> findUser(String login) {
    try {
      final GithubUser user = githubApi.getUser(login);
      return Optional.ofNullable(user);
    } catch (FeignException.NotFound e) {
      return Optional.empty();
    } catch (FeignClientException e) {
      throw new GithubException(e.getMessage(), e);
    }
  }
}
