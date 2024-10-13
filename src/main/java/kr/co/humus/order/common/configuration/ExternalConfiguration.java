package kr.co.humus.order.common.configuration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "external-api")
@Getter
@Setter
@RequiredArgsConstructor
public class ExternalConfiguration {
    private String host;
    private String getOrder;
    private String sendOrder;


    public String getOrderUrl() {
        return String.format("%s:%s", this.host, this.getOrder);
    }

    public String getSendOrderUrl() {
        return String.format("%s:%s", this.host, this.sendOrder);
    }
}
