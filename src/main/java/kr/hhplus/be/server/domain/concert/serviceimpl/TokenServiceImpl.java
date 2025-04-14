package kr.hhplus.be.server.domain.concert.serviceimpl;

import kr.hhplus.be.server.domain.concert.entity.User;
import org.springframework.stereotype.Service;
import kr.hhplus.be.server.domain.concert.service.TokenService;

@Service
public class TokenServiceImpl implements TokenService {


    @Override
    public User validateToken(User user) {
        return null;
    }

    @Override
    public void deleteToken(User user) {
    }
}
