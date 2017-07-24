package pl.com.sages.connect.security.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import pl.com.sages.connect.common.web.UriBuilder;

@Configuration
public class Cors extends WebMvcConfigurerAdapter {

    private static final String ALLOWED_ORIGINS = "*";

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping(UriBuilder.ALL_URIS)
                .allowedOrigins(ALLOWED_ORIGINS)
                .allowedMethods("*");
    }

}
