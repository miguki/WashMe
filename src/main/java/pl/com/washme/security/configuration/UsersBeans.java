package pl.com.washme.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import pl.com.washme.security.repository.UsersRepository;
import pl.com.washme.security.service.UsersService;

@Configuration
public class UsersBeans {

    @Bean
    public UsersService usersService(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        return new UsersService(usersRepository, passwordEncoder);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new StandardPasswordEncoder();
    }

}
