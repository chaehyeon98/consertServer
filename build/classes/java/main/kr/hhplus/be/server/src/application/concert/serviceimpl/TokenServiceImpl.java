package src.application.concert.serviceimpl;

import org.springframework.stereotype.Service;
import src.application.concert.service.TokenService;
import src.domain.concert.entity.UserEntity;

@Service
public class TokenServiceImpl implements TokenService {


    @Override
    public UserEntity validateToken(UserEntity user) {
        return null;
    }
}
