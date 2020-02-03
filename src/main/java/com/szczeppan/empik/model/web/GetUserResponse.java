package com.szczeppan.empik.model.web;

import com.szczeppan.empik.model.domain.User;
import java.time.LocalDateTime;
import java.util.StringJoiner;

public class GetUserResponse {

  private long id;
  private String login;
  private String name;
  private String type;
  private String avatarUrl;
  private LocalDateTime createdAt;
  private Double calculations;

  public GetUserResponse() {
  }

  public GetUserResponse(User user) {
    id = user.getId();
    login = user.getLogin();
    name = user.getName();
    type = user.getType();
    avatarUrl = user.getAvatarUrl();
    createdAt = user.getCreatedAt();
    calculations = user.getCalculations();
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getAvatarUrl() {
    return avatarUrl;
  }

  public void setAvatarUrl(String avatarUrl) {
    this.avatarUrl = avatarUrl;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public double getCalculations() {
    return calculations;
  }

  public void setCalculations(double calculations) {
    this.calculations = calculations;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", GetUserResponse.class.getSimpleName() + "[", "]")
        .add("id=" + id)
        .add("login='" + login + "'")
        .add("name='" + name + "'")
        .add("type='" + type + "'")
        .add("avatarUrl='" + avatarUrl + "'")
        .add("createdAt=" + createdAt)
        .add("calculations=" + calculations)
        .toString();
  }
}
