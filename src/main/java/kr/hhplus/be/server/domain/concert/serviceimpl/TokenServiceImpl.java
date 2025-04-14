package domain.concert.serviceimpl;

import domain.concert.entity.User;
import org.springframework.stereotype.Service;
import domain.concert.service.TokenService;

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
