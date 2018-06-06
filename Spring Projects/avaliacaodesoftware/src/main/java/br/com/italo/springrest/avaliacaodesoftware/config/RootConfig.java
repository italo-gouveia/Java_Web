package br.com.italo.springrest.avaliacaodesoftware.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("br.com.italo.springrest.avaliacaodesoftware")
@EnableWebMvc
public class RootConfig {

}
