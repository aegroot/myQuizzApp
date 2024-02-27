package alex.app.myQuizzApp.security;

import alex.app.myQuizzApp.security.user.UserRepository;
import alex.app.myQuizzApp.security.user.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;


@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.httpBasic(Customizer.withDefaults());

        http.authorizeHttpRequests(
                c -> c.requestMatchers(HttpMethod.GET, "/api/v1/test/example","api/v1,test,example").permitAll()
                        .requestMatchers("api/v1/test/").hasRole("USER")
                        .anyRequest().authenticated()
        );

        return http.build();
    }

    @Bean
    public UserDetailsService detailsService(DataSource dataSource){

        UserDetails user=User.withUsername("tom44").password(encoder()
                .encode("testMe")).roles(UserRole.USER.toString()).build();

        UserDetails user2=User.withUsername("adil44").password(encoder()
                .encode("testAdmin")).roles(UserRole.ADMIN.toString()).build();

        JdbcUserDetailsManager jdbcUserDetailsManager=new JdbcUserDetailsManager(dataSource);

        jdbcUserDetailsManager.createUser(user);
        jdbcUserDetailsManager.createUser(user2);

        return  jdbcUserDetailsManager;
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();}



}
