package domain.concert.serviceimpl;

import domain.concert.entity.Concert;
import domain.concert.entity.ConcertDate;
import domain.concert.entity.User;
import domain.concert.repository.ConcertRepository;
import domain.concert.service.ConcertService;
import domain.concert.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class ConcertServiceImpl  implements ConcertService {

    @Autowired
    private TokenService tokenService;

    private final ConcertRepository repo;

    public ConcertServiceImpl(ConcertRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Concert> getConcert(String name) {

        return repo.getConcert(name);
    }

    @Override
    public List<ConcertDate> getDate(BigInteger concertId, User user){

        tokenService.validateToken(user);

        return repo.getDate(concertId);
    }
}
