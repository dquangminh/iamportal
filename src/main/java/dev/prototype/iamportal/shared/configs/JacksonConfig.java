package dev.prototype.iamportal.shared.configs;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.prototype.iamportal.shared.utils.JsonUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class JacksonConfig {

    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        return JsonUtil.mapper();
    }
}
