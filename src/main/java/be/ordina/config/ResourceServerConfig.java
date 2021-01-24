package be.ordina.config;

import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

public class ResourceServerConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .exceptionHandling()
                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)).and().cors().and()
                .authorizeRequests()
                .mvcMatchers("/api/heroes/**").hasAuthority("SCOPE_heroes").anyRequest().denyAll()
                .mvcMatchers("/v3/api-docs","/swagger-ui/index.html","/swagger-ui/**").permitAll()
                .and().oauth2ResourceServer().jwt();
    }


}
