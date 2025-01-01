package com.example.ms_order.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "jwt.auth.converter")
@Primary
public class JwtAuthConverterProperties {
        private String principleAttribute = "sub"; // Default value
        private String resourceId;

        public String getPrincipleAttribute() {
            return principleAttribute;
        }

        public void setPrincipleAttribute(String principleAttribute) {
            this.principleAttribute = principleAttribute;
        }

        public String getResourceId() {
            return resourceId;
        }

        public void setResourceId(String resourceId) {
            this.resourceId = resourceId;
        }

}
