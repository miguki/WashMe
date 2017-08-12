package pl.com.washme.security.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import pl.com.washme.common.model.ResultPage;
import pl.com.washme.security.configuration.Role;
import pl.com.washme.security.entity.Authority;
import pl.com.washme.security.entity.User;
import pl.com.washme.security.repository.UsersRepository;

import java.security.Principal;

public class UsersService implements UserDetailsService {

    private UsersRepository usersRepository;
    private PasswordEncoder passwordEncoder;

    public UsersService(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void addUser(User user) {
        user.setActive(true);
        encodeUserPassword(user);
        setDefaultAuthority(user);
        usersRepository.saveAndFlush(user);
    }

    public ResultPage<User> getUsers(int pageNumber, int pageSize) {
        Page<User> usersPage = usersRepository.findAll(new PageRequest(pageNumber, pageSize));
        return new ResultPage<>(usersPage.getContent(), usersPage.getNumber(), usersPage.getTotalPages());
    }

    public void validateOwnership(Principal principal, Long resourceId) {
        User user = (User) principal;
        if (!user.getId().equals(resourceId)) {
            throw new WrongOwnerException();
        }
    }

    private void encodeUserPassword(User user) {
        String password = user.getPassword();
        String encodedPassword = passwordEncoder.encode(password);
        user.setPassword(encodedPassword);
    }

    private void setDefaultAuthority(User user) {
        Authority authority = new Authority(Role.USER.nameWithPrefix());
        user.addAuthority(authority);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usersRepository.getByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User %s not found", username)));
    }

    public User getCurrentUser() {
        OAuth2Authentication oAuth2Authentication = ((OAuth2Authentication) SecurityContextHolder.getContext().getAuthentication());
        return (User) oAuth2Authentication.getPrincipal();
    }

//    public User getCurrentUser() {
//        Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
//        String login = currentUser.getName();
//        return usersRepository.getByLogin(login).get();
//    }

}
