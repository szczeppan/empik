package com.szczeppan.empik.repositories;

import com.szczeppan.empik.model.domain.LoginRequestCounter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRequestCountersRepository extends JpaRepository<LoginRequestCounter, String> {

  @Modifying
  @Query("update LoginRequestCounter l set l.count = l.count + 1 where l.login = :login")
  void incrementCounter(String login);
}
