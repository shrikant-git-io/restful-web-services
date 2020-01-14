package com.rest.webservices.restfulwebservices.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.net.InetAddress;

@ConfigurationProperties("acme")
@Validated
public class AcmeProperties {



    @NotNull
    private InetAddress remoteAddress;

    @Autowired
    private AnotherComponent anotherComponent;

    @ConfigurationProperties(prefix = "another")
    @Bean
    public AnotherComponent getAnotherComponent() {
        return anotherComponent;
    }

    public void setAnotherComponent(AnotherComponent anotherComponent) {
        this.anotherComponent = anotherComponent;
    }


    public InetAddress getRemoteAddress() {
        return remoteAddress;
    }

    public void setRemoteAddress(InetAddress remoteAddress) {
        this.remoteAddress = remoteAddress;
    }
}
