package com.example.ms_order.services.impl;

import com.example.ms_order.client.KeycloakClient;
import com.example.ms_order.dto.LoginDto;
import com.example.ms_order.dto.TokenDto;
import com.example.ms_order.services.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final KeycloakClient keycloakClient;
    private TokenDto tokenDto;

    @Override
    public TokenDto login(LoginDto loginDto) {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("grant_type", "password");
        map.add("username", loginDto.username());
        map.add("password", loginDto.password());
        map.add("client_id", "order-client");
        ResponseEntity<AccessTokenResponse> accessToken = keycloakClient.login(map);
        if (Objects.isNull(accessToken) || Objects.isNull(accessToken.getBody()))
            throw new RuntimeException();

        tokenDto = TokenDto.builder()
                .accessToken(accessToken.getBody().getToken())
                .expIn(accessToken.getBody().getExpiresIn())
                .refExpIn(accessToken.getBody().getRefreshExpiresIn())
                .refreshToken(accessToken.getBody().getRefreshToken())
                .build();

        return tokenDto;
    }
}
