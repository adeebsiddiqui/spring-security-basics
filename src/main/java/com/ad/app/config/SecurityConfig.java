package com.ad.app.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
                .antMatchers("/").permitAll() //this gives access to index.html without authentication
                /** https://stackoverflow.com/questions/69835/how-do-i-use-nant-ant-naming-patterns */
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login") //This is needed to allow custom login page to be rendered
                .permitAll()
                .defaultSuccessUrl("/success", true)
                .and()
            .logout()
                .logoutUrl("/logout") //see the link below
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
                .logoutSuccessUrl("/login")
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");
    }
}

/** https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/config/annotation/web/configurers/LogoutConfigurer.html#logoutUrl-java.lang.String- */
