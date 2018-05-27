package com.example.app.Configuration;

import com.example.app.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private UserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userService).passwordEncoder(getBCryptPasswordEncoder());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .authorizeRequests()
                .antMatchers("/","/register", "/login").permitAll()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/user/**").access("hasRole('USER') OR hasRole('ADMIN')")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").permitAll()
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
                    .rememberMe()
                    .rememberMeCookieName("TheBoardFinders")
                    .rememberMeParameter("remember")
                    .key("1random%2316secretcryptoTUES")
                    .tokenValiditySeconds(2629743)
                .and()
                    .logout().logoutSuccessUrl("/login?logout").permitAll()
                .and()
                    .exceptionHandling().accessDeniedPage("/unauthorized")
                .and()
                    .csrf().disable();
    }

    @Bean
    public BCryptPasswordEncoder getBCryptPasswordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

}