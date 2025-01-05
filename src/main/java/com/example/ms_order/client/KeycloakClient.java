package com.example.ms_order.client;

import org.keycloak.representations.AccessTokenResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient(name = "keycloak-client", url = "http://localhost:8084")
public interface KeycloakClient {
    @PostMapping(value = "/realms/test-spring-client/protocol/openid-connect/token",
            consumes = "application/x-www-form-urlencoded")
    ResponseEntity<AccessTokenResponse> login(@RequestBody Map<String, ?> form);
}
