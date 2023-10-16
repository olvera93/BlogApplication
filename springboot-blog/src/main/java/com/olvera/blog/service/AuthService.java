package com.olvera.blog.service;

import com.olvera.blog.payload.LoginDto;

public interface AuthService {

    String login(LoginDto loginDto);

}
