package vinkenstein;

import domain.HistoryClient;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

//@Profile("test")
@TestConfiguration
public class TestAppConfig extends AppConfig {
    @Bean
    ThirdPartyClient thirdPartyClient() {
        return new ThirdPartyClient() {
            @Override
            public String get() {
                return " mock!!!";
            }
        };
    }

    @Bean
    HistoryClient historyClient(String remoteServerHostname) {
        return new MockHistoryClient(remoteServerHostname);
    }

}
