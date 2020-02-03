package com.szczeppan.empik.exceptions;

public class GithubException extends RuntimeException {

  public GithubException(String message, Throwable cause) {
    super(message, cause);
  }
}
