/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package org.springframework.security.samples.config;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.samples.service.UserServiceImpl;

/**
 * @author Joe Grandja
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  UserServiceImpl userSerivce;

  // @formatter:off
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // super.configure(http);
    http.authorizeRequests()
        // .antMatchers("/css/**", "/index").permitAll()
        .antMatchers("/user/**")
//        .hasRole("USER")
        .access("hasRole('USER') or hasAnyAuthority('ROOT')")
        .and().formLogin().loginPage("/login")
//        .successForwardUrl("/user/info")
        .failureUrl("/login-error")
    // .and()
    // .logout().logoutUrl("/logout")
    ;
  }
  // @formatter:on

  /*
   * (non-Javadoc)
   * @param auth
   * @throws Exception
   * @see
   * org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#
   * configure(org.springframework.security.config.annotation.authentication.builders.
   * AuthenticationManagerBuilder)
   */
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    // TODO Auto-generated method stub
    auth
//      .and()
//      .inMemoryAuthentication().withUser("user2").password("password2").roles("USER")
      .userDetailsService(userSerivce) // 替换默认InMemoryUserDetailsManager
      .passwordEncoder(passwordEncoder()) // 替换默认PlaintextPasswordEncoder
      ;
  }

  // @formatter:off
  // @Autowired 会覆盖yam里配置的user
  // public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
  // auth
  // .inMemoryAuthentication()
  // .withUser("user2").password("password2").roles("USER");
  // }


  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
  // @formatter:on
}
