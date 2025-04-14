package domain.concert.service;

import domain.concert.entity.User;

public interface TokenService {

    User validateToken(User user);

    void deleteToken(User user);
}
