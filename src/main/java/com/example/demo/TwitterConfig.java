package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;

@Configuration
public class TwitterConfig {

    @Value("${spring.social.twitter.appId}")
    private String appId;

    @Value("${spring.social.twitter.appSecret}")
    private String appSecret;

    @Bean
    public Twitter twitter() {
        return new TwitterTemplate(appId, appSecret);
    }
}

