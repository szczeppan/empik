package com.szczeppan.empik.model.domain;

import java.util.StringJoiner;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LOGIN_REQUESTS_COUNTERS")
public class LoginRequestCounter {

  @Id
  @Column(name = "LOGIN")
  private String login;

  @Column(name = "REQUEST_COUNT")
  private Long count;

  public LoginRequestCounter() {
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public Long getCount() {
    return count;
  }

  public void setCount(Long count) {
    this.count = count;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", LoginRequestCounter.class.getSimpleName() + "[", "]")
        .add("login='" + login + "'")
        .add("count=" + count)
        .toString();
  }
}
