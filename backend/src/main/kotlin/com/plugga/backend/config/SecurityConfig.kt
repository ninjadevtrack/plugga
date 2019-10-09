package com.plugga.backend.config

import com.plugga.backend.authentication.RestAuthenticationEntryPoint
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
@EnableWebSecurity
private class SecurityConfig(
    private val restAuthenticationEntryPoint: RestAuthenticationEntryPoint
) : WebSecurityConfigurerAdapter() {

    @Autowired
    private val environment: Environment? = null

    @Throws(Exception::class)
    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.inMemoryAuthentication()
            .withUser(environment?.getProperty("ROOT_ADMIN_USERNAME"))
            .password(encoder().encode(environment?.getProperty("ROOT_ADMIN_PASSWORD")))
            .roles("ADMIN")
            .and()
            .withUser(environment?.getProperty("TEST_USER_USERNAME"))
            .password(encoder().encode(environment?.getProperty("TEST_USER_PASSWORD")))
            .roles("USER")
    }

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http
            .httpBasic()
            .and()
            .exceptionHandling()
            .authenticationEntryPoint(restAuthenticationEntryPoint)
            .and()
            .authorizeRequests()
            .antMatchers("/api/admin/**").hasRole("ADMIN")
            .antMatchers(HttpMethod.DELETE, "/api/cards/**").hasRole("ADMIN")
            .antMatchers("/api/cards/**").authenticated()
            .antMatchers(HttpMethod.DELETE, "/api/deck_cards/**").hasRole("ADMIN")
            .antMatchers("/api/deck_cards/**").authenticated()
            .antMatchers(HttpMethod.DELETE, "/api/decks/**").hasRole("ADMIN")
            .antMatchers("/api/decks/**").authenticated()
            .antMatchers(HttpMethod.DELETE, "/api/piles/**").hasRole("ADMIN")
            .antMatchers("/api/piles/**").authenticated()
            .antMatchers(HttpMethod.DELETE, "/api/sides/**").hasRole("ADMIN")
            .antMatchers("/api/sides/**").authenticated()
            .antMatchers(HttpMethod.DELETE, "/api/user_decks/**").hasRole("ADMIN")
            .antMatchers("/api/user_decks/**").authenticated()
            .antMatchers(HttpMethod.POST, "/api/users/**").permitAll()
            .antMatchers(HttpMethod.DELETE, "/api/users/**").hasRole("ADMIN")
            .antMatchers("/api/users/**").authenticated()
            .and()
            .csrf().disable()
            .formLogin().disable()
    }

    @Bean
    fun encoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }
}
