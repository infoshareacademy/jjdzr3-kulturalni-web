package com.infoshareacademy.kulturalniweb.config;

import com.infoshareacademy.kulturalniweb.services.MyUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String HOME_PAGE = "/home";
    private static final String LOGIN_PAGE = "/sign-in";
    private static final String LOGOUT_PAGE = "/sign-out";


    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    MyUserDetailsService userDetailsService;

    public WebSecurityConfig(MyUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().disable();
        http
                .authorizeRequests()
                .antMatchers("/favourites", "/addEvent", "/editEvent")
                .authenticated()
                .and()
                .formLogin()
                .loginPage(LOGIN_PAGE)
                .defaultSuccessUrl(HOME_PAGE)
                .and()
                .logout()
                .logoutUrl(LOGOUT_PAGE)
                .logoutSuccessUrl(HOME_PAGE)
                .deleteCookies("JSESSIONID");



    }
}
