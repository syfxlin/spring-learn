package me.ixk.security_token.security;

import me.ixk.security_token.security.filter.TokenAuthenticationFilter;
import me.ixk.security_token.utils.Jwt;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class TokenSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(final AuthenticationManagerBuilder auth)
        throws Exception {
        auth.authenticationProvider(
            new TokenAuthenticationProvider(new Jwt("key", "HS256"))
        );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .addFilterAfter(
                new TokenAuthenticationFilter(),
                BasicAuthenticationFilter.class
            )
            .authorizeRequests()
            // 允许所有访问，使用注解进行权限控制
            .anyRequest()
            .permitAll()
            .and()
            .csrf()
            .disable()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
}
