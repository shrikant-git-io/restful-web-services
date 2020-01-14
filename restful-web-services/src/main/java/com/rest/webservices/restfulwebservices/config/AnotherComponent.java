package com.rest.webservices.restfulwebservices.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AnotherComponent {

    private String thirdpartyname;
    @Value("${attributeValue}")
    private String testValueAttribute;

    public String getTestValueAttribute() {
        return testValueAttribute;
    }

    public void setTestValueAttribute(String testValueAttribute) {
        this.testValueAttribute = testValueAttribute;
    }

    public String getThirdpartyname() {
        return thirdpartyname;
    }

    public void setThirdpartyname(String thirdpartyname) {
        this.thirdpartyname = thirdpartyname;
    }
}
