package com.szczeppan.empik.configs;

import com.szczeppan.empik.model.github.GithubUser;
import com.szczeppan.empik.transformers.GithubTransformer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.http.dsl.Http;
import org.springframework.messaging.MessageChannel;

@Configuration
@EnableIntegration
@IntegrationComponentScan
public class GithubIntegrationConfig {

  @Bean
  public MessageChannel githubUserInput() {
    return new DirectChannel();
  }

  @Bean
  public MessageChannel githubUserOutput() {
    return new DirectChannel();
  }

  @Bean
  public IntegrationFlow githubUserFlow(GithubTransformer githubTransformer) {
    return IntegrationFlows.from("githubUserInput")
        .handle(Http.outboundGateway("https://api.github.com/users/{login}")
            .httpMethod(HttpMethod.GET)
            .uriVariable("login", "payload")
            .expectedResponseType(GithubUser.class))
        .transform(githubTransformer)
        .get();
  }

}
