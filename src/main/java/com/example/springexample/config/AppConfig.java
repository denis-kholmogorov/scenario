package com.example.springexample.config;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * AppConfig
 */

@Component
@ConfigurationProperties(prefix = "app")
public class AppConfig {

    private String name;
    private int maxConnections;
    private boolean enableFeature;

    @PostConstruct
    public void printConfig(){
        System.out.println(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxConnections() {
        return maxConnections;
    }

    public void setMaxConnections(int maxConnections) {
        this.maxConnections = maxConnections;
    }

    public boolean isEnableFeature() {
        return enableFeature;
    }

    public void setEnableFeature(boolean enableFeature) {
        this.enableFeature = enableFeature;
    }

    @Override
    public String toString() {
        return "AppConfig{" +
                "name='" + name + '\'' +
                ", maxConnections=" + maxConnections +
                ", enableFeature=" + enableFeature +
                '}';
    }


}
