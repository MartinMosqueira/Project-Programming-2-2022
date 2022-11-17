package app.poject.ReportsService.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "main-server", ignoreUnknownFields = false)
public class MainServerConfiguration {
    private String url;
    private String uuid;
    private String token;
}
