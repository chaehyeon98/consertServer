package kr.hhplus.be.server.application.concert.service;

import kr.hhplus.be.server.domain.concert.entity.UserEntity;

public interface TokenService {

    UserEntity validateToken(UserEntity user);

    void deleteToken(UserEntity user);
}
