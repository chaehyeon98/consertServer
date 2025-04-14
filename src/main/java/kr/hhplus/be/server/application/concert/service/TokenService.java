package kr.hhplus.be.server.application.concert.service;

import kr.hhplus.be.server.domain.concert.entity.User;

public interface TokenService {

    User validateToken(User user);

    void deleteToken(User user);
}
