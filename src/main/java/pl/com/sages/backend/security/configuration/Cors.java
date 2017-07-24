package pl.com.sages.backend.security.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import pl.com.sages.backend.common.web.UriBuilder;

@Configuration
public class Cors extends WebMvcConfigurerAdapter {

    private static final String ALLOWED_ORIGINS = "http://localhost:4200";
    private static final String ALLOWED_METHODS = "*";

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping(UriBuilder.ALL_URIS)
                .allowedOrigins(ALLOWED_ORIGINS)
                .allowedMethods(ALLOWED_METHODS);
    }

}
