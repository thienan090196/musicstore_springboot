package com.nashtech.musicstore_springboot.config;

import com.nashtech.musicstore_springboot.utilities.ConstantValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@ComponentScan("com.nashtech.musicstore_springboot.service")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf()
            .disable();

        http
            .authorizeRequests()
                .antMatchers("/**/management/**")
                .hasRole(ConstantValues.ADMIN_ROLE);

        http
            .authorizeRequests()
                .antMatchers("/checkout/viewShippingInfo" , "/checkout/addShippingInfo")
                .hasAnyRole(ConstantValues.ADMIN_ROLE, ConstantValues.USER_ROLE);

        http
            .authorizeRequests()
                .and()
                .formLogin()
                .loginPage("/account/login")
                .usernameParameter("email")
                .passwordParameter("password");

        http
            .authorizeRequests()
            .and()
            .logout()
            .invalidateHttpSession(true)
            .logoutSuccessUrl("/")
            .clearAuthentication(true)
            .logoutUrl("/account/logout");

        http
            .authorizeRequests()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/page-not-found");
    }
}
