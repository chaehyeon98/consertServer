package kr.hhplus.be.server.domain.concert.serviceimpl;

import kr.hhplus.be.server.domain.concert.entity.Concert;
import kr.hhplus.be.server.domain.concert.entity.ConcertDate;
import kr.hhplus.be.server.domain.concert.entity.User;
import kr.hhplus.be.server.domain.concert.repository.ConcertDateRepository;
import kr.hhplus.be.server.domain.concert.repository.ConcertRepository;
import kr.hhplus.be.server.domain.concert.service.ConcertService;
import kr.hhplus.be.server.domain.concert.service.TokenService;
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
    public List<Concert> getConcert() {

        return repo.getConcert();
    }

    @Override
    public List<ConcertDate> getDate(long concertId, User user){

        tokenService.validateToken(user);

        return repoDate.getDate(concertId);
    }
}
