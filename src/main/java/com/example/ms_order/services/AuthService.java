package com.example.ms_order.services;

import com.example.ms_order.dto.LoginDto;
import com.example.ms_order.dto.TokenDto;

public interface AuthService {

    TokenDto login(LoginDto loginDto);

}
