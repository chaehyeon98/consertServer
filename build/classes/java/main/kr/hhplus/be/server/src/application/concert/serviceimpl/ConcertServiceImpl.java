package src.application.concert.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import src.application.concert.service.ConcertService;
import src.application.concert.service.TokenService;
import src.domain.concert.entity.ConcertDateEntity;
import src.domain.concert.entity.ConcertEntity;
import src.domain.concert.entity.ConcertSeatEntity;
import src.domain.concert.entity.UserEntity;
import src.domain.concert.repository.ConcertRepository;

import java.math.BigInteger;
import java.util.List;

public class ConcertServiceImpl  implements ConcertService {

    @Autowired
    private TokenService tokenService;

    private final ConcertRepository repo;

    public ConcertServiceImpl(ConcertRepository repo) {
        this.repo = repo;
    }

    @Override
    public ConcertEntity getConcert(String name) {
        return repo.getConcert(name);
    }

    @Override
    public List<ConcertDateEntity> getDate(BigInteger concertId, UserEntity user){
        tokenService.validateToken(user);

        return repo.getDate(concertId);
    }

    @Override
    public List<ConcertSeatEntity> getSeat(BigInteger seat_id, UserEntity user) {
        tokenService.validateToken(user);

        return repo.getSeat(seat_id);
    }
}
