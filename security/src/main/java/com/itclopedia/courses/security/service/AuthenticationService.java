package com.itclopedia.courses.security.service;

import com.itclopedia.courses.security.config.JwtAuthenticationResponse;
import com.itclopedia.courses.security.dto.SignInRequestDTO;
import com.itclopedia.courses.security.dto.SignUpRequestDT0;

public interface AuthenticationService {

    /**
     * Регистрация пользователя
     *
     * @param request данные пользователя
     * @return токен
     */
    JwtAuthenticationResponse signUp(SignUpRequestDT0 request);

    /**
     * Аутентификация пользователя
     *
     * @param request данные пользователя
     * @return токен
     */
    JwtAuthenticationResponse signIn(SignInRequestDTO request);
}