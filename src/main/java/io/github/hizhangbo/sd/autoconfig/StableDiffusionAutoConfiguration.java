package io.github.hizhangbo.sd.autoconfig;

import io.github.hizhangbo.sd.client.StableDiffusionClient;
import io.github.hizhangbo.sd.property.StableDiffusionProperties;
import okhttp3.OkHttpClient;
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
    public StableDiffusionClient stableDiffusionClient() {
        return new StableDiffusionClient(stableDiffusionProperties);
    }
}
