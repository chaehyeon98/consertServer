package kr.hhplus.be.server.application.concert.serviceimpl;

import kr.hhplus.be.server.domain.concert.entity.UserEntity;
import org.springframework.stereotype.Service;
import kr.hhplus.be.server.application.concert.service.TokenService;

@Service
public class TokenServiceImpl implements TokenService {


    @Override
    public UserEntity validateToken(UserEntity user) {
        return null;
    }

    @Override
    public void deleteToken(UserEntity user) {
    }
}
