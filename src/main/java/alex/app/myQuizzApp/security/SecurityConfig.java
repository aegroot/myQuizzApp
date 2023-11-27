package alex.app.myQuizzApp.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.httpBasic(Customizer.withDefaults());

        http.authorizeHttpRequests(
                c -> c.requestMatchers("/api/v1/test").hasAnyRole("USER")
                        .anyRequest().authenticated()
        );


        http.authorizeHttpRequests(c->c.anyRequest().authenticated());
        return http.build();
    }
}
