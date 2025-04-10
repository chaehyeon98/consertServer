package src.application.concert.service;

import src.domain.concert.entity.UserEntity;

public interface TokenService {

    UserEntity validateToken(UserEntity user);
}
