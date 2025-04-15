package domain.concert.serviceimpl;

import domain.concert.entity.Concert;
import domain.concert.entity.ConcertDate;
import domain.concert.entity.User;
import domain.concert.repository.ConcertDateRepository;
import domain.concert.repository.ConcertRepository;
import domain.concert.service.ConcertService;
import domain.concert.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConcertServiceImpl  implements ConcertService {

    @Autowired
    private TokenService tokenService;

    private final ConcertRepository repo;

    private final ConcertDateRepository repoDate;

    public ConcertServiceImpl(ConcertRepository repo, ConcertDateRepository repoDate) {
        this.repo = repo;
        this.repoDate = repoDate;
    }

    @Override
    public List<Concert> getConcert(String name) {

        return repo.getConcert(name);
    }

    @Override
    public List<ConcertDate> getDate(long concertId, User user){

        tokenService.validateToken(user);

        return repoDate.getDate(concertId);
    }
}
