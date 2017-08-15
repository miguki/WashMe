package pl.com.washme.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import pl.com.washme.common.web.UriBuilder;

import static org.springframework.http.HttpMethod.*;

public class OAuth2 {

    private static final String CLIENT_ID = "connect-app";
    private static final String GRANT_TYPE = "password";
    private static final String SCOPE = "web";
    private static final String USERS_URI = UriBuilder.PREFIX + "/users";
    private static final String ACTIVE_USER_URI = UriBuilder.PREFIX + "/users/active";

    @EnableResourceServer
    @Configuration
    public static class ResourceServer extends ResourceServerConfigurerAdapter {

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .antMatchers(UriBuilder.PUBLIC_URIS).permitAll()
                    .antMatchers(POST, "/api-v1/clients").permitAll()
                    .antMatchers(POST, "/api-v1/carWash").permitAll()
                    .antMatchers(POST, "/api-v1/service-type").permitAll()
                    .antMatchers(POST, USERS_URI).permitAll()
                    .antMatchers(GET, ACTIVE_USER_URI).permitAll()
                    .antMatchers(UriBuilder.ALL_URIS).permitAll();

        }

    }

    @EnableAuthorizationServer
    @Configuration
    public static class AuthorizationServer extends AuthorizationServerConfigurerAdapter {

        @Autowired
        private AuthenticationManager authenticationManagerBean;

        @Override
        public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
            clients.inMemory()
                    .withClient(CLIENT_ID)
                    .authorizedGrantTypes(GRANT_TYPE)
                    .scopes(SCOPE);
        }

        @Override
        public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
            endpoints.authenticationManager(authenticationManagerBean);
        }

        @Override
        public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
            security.allowFormAuthenticationForClients();
        }

    }

}
