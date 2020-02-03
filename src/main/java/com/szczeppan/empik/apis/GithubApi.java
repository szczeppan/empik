package com.szczeppan.empik.apis;

import com.szczeppan.empik.model.github.GithubUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "github", url = "https://api.github.com")
public interface GithubApi {

  @GetMapping("/users/{login}")
  GithubUser getUser(@PathVariable String login);
}
