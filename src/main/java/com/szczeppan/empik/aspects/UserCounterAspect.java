package com.szczeppan.empik.aspects;

import com.szczeppan.empik.model.domain.LoginRequestCounter;
import com.szczeppan.empik.repositories.LoginRequestCountersRepository;
import java.util.Optional;
import javax.persistence.LockModeType;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Aspect
@Component
public class UserCounterAspect {

  private static final Logger LOG = LoggerFactory.getLogger(UserCounterAspect.class);
  private final LoginRequestCountersRepository loginRequestCountersRepository;

  public UserCounterAspect(
      LoginRequestCountersRepository loginRequestCountersRepository) {
    this.loginRequestCountersRepository = loginRequestCountersRepository;
  }

  @Around("@annotation(com.szczeppan.empik.annotations.UserCounter)")
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public Object logUserRequest(ProceedingJoinPoint joinPoint) throws Throwable {

    final String login = String.valueOf(joinPoint.getArgs()[0]);
    Optional<LoginRequestCounter> counter = loginRequestCountersRepository.findById(login);

    if (counter.isEmpty()) {
      createCounter(login);
    }

    loginRequestCountersRepository.incrementCounter(login);
    return joinPoint.proceed();
  }

  @Lock(LockModeType.PESSIMISTIC_WRITE)
  public void createCounter(String login) {
    LOG.debug("creating a new counter for {}", login);
    LoginRequestCounter counter = new LoginRequestCounter();
    counter.setLogin(login);
    counter.setCount(0L);
    loginRequestCountersRepository.saveAndFlush(counter);
  }

}
