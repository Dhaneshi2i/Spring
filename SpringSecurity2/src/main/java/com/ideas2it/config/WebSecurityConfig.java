package com.ideas2it.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebSecurity
@ComponentScan("com.ideas2it")
public class WebSecurityConfig extends WebSecurityConfiguration {

    @Bean
    public UserDetailsService userDetailsService() throws Exception {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withDefaultPasswordEncoder().username("dhanesh").
                password("dk@i2i").roles("USER").build());
        return manager;
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().
        antMatchers("/index","/user","/").permitAll().
        antMatchers("/admin").authenticated()
        .and()
        .formLogin()
        .loginPage("/login")
        .and()
        .logout()
        .logoutRequestMatcher(new AndRequestMatcher());

    }
}

 /*http
                .antMatcher("/")
                .authorizeRequests()
                .anyRequest().hasRole("ADMIN")
                .and()
                .httpBasic();


                http.authorizeRequests().anyRequest()
                .hasRole("USER").and().formLogin().and().httpBasic()
                .and().logout().logoutUrl("j_spring_security_logout")
                .logoutSuccessUrl("/");*/
