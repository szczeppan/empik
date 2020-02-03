package com.szczeppan.empik.aspects;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.szczeppan.empik.model.domain.LoginRequestCounter;
import com.szczeppan.empik.repositories.LoginRequestCountersRepository;
import java.util.Optional;
import org.aspectj.lang.ProceedingJoinPoint;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserCounterAspectTest {

  @Mock
  private LoginRequestCountersRepository loginRequestCountersRepository;

  @InjectMocks
  private UserCounterAspect userCounterAspect;

  @Test
  void logUserRequest_shouldIncrementRequestCounterWhenCounterExists() throws Throwable{
    final LoginRequestCounter counter = new LoginRequestCounter();
    counter.setLogin("login");
    counter.setCount(1L);
    when(loginRequestCountersRepository.findById("login")).thenReturn(Optional.of(
        counter));

    final ProceedingJoinPoint joinPoint = mock(ProceedingJoinPoint.class);
    when(joinPoint.getArgs()).thenReturn(new Object[]{"login"});

    userCounterAspect.logUserRequest(joinPoint);

    verify(loginRequestCountersRepository).incrementCounter("login");
  }

  @Test
  void logUserRequest_shouldCreateAndIncrementRequestCounterWhenCounterNotExists() throws Throwable {
    when(loginRequestCountersRepository.findById("login")).thenReturn(Optional.empty());

    final ProceedingJoinPoint joinPoint = mock(ProceedingJoinPoint.class);
    when(joinPoint.getArgs()).thenReturn(new Object[]{"login"});

    userCounterAspect.logUserRequest(joinPoint);

    verify(loginRequestCountersRepository).incrementCounter("login");
    verify(loginRequestCountersRepository).saveAndFlush(any(LoginRequestCounter.class));
  }

  @Test
  void createCounter() {
  }
}
