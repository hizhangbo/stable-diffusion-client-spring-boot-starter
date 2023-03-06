package io.github.hizhangbo.sd.autoconfig;

import io.github.hizhangbo.sd.client.StableDiffusionClient;
import io.github.hizhangbo.sd.property.StableDiffusionProperties;
import io.github.hizhangbo.sd.client.HttpClient;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(StableDiffusionProperties.class)
public class StableDiffusionAutoConfiguration {

    private final StableDiffusionProperties stableDiffusionProperties;

    public StableDiffusionAutoConfiguration(StableDiffusionProperties stableDiffusionProperties) {
        this.stableDiffusionProperties = stableDiffusionProperties;
    }

    @Bean
    public HttpClient httpClient() {
        return new HttpClient(stableDiffusionProperties);
    }

    @Bean
    public StableDiffusionClient stableDiffusionClient(HttpClient httpClient) {
        return new StableDiffusionClient(httpClient);
    }
}
