package app.project.FranchiseMicroservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "report.server")
public class ReportServerConfiguration {
    private String urlHistory;
    private String urlRecurrent;
    private String urlCancel;
}
