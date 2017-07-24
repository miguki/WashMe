package pl.com.sages.connect.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import pl.com.sages.connect.security.repository.AuthoritiesRepository;
import pl.com.sages.connect.security.repository.UsersRepository;
import pl.com.sages.connect.security.service.UsersService;

@Configuration
public class UsersBeans {

    @Bean
    public UsersService usersService(UsersRepository usersRepository, AuthoritiesRepository authoritiesRepository, PasswordEncoder passwordEncoder) {
        return new UsersService(usersRepository, authoritiesRepository, passwordEncoder);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new StandardPasswordEncoder();
    }

}
