package com.szczeppan.empik.handlers;

import com.szczeppan.empik.exceptions.GithubException;
import com.szczeppan.empik.exceptions.UserNotFoundException;
import java.util.StringJoiner;
import javax.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.util.Strings;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResponseExceptionHandler {

  @ExceptionHandler({
      UserNotFoundException.class
  })
  protected ResponseEntity<ErrorResponse> notFound(Exception ex, HttpServletRequest request) {
    return handleException(ex, request, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler({
      GithubException.class
  })
  protected ResponseEntity<ErrorResponse> internalError(Exception ex, HttpServletRequest request) {
    return handleException(ex, request, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  private ResponseEntity<ErrorResponse> handleException(Exception ex, HttpServletRequest request, HttpStatus status) {
    ErrorResponse errorResponse = new ErrorResponse(ex, request.getRequestURL().toString(), ex.getLocalizedMessage());
    return new ResponseEntity<>(errorResponse, status);
  }

  class ErrorResponse {

    private final String message;
    private final String url;

    ErrorResponse(Exception ex, String url, String message) {
      this.message = Strings.isBlank(message) ? ex.getClass().getName() : message;
      this.url = url;
    }

    public String getMessage() {
      return message;
    }

    public String getUrl() {
      return url;
    }

    @Override
    public String toString() {
      return new StringJoiner(", ", ErrorResponse.class.getSimpleName() + "[", "]")
          .add("message='" + message + "'")
          .add("url='" + url + "'")
          .toString();
    }
  }
}
