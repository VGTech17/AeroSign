package com.aerosign.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(KeyStoreProperties.class)
public class KeyStoreConfig {
}
