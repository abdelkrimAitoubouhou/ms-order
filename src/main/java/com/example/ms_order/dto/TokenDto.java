package com.example.ms_order.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TokenDto {

    private String accessToken;
    private Long expIn;
    private Long refExpIn;
    private String refreshToken;

}