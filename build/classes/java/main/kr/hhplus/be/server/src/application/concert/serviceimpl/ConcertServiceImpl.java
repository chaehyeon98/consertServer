package src.application.concert.serviceimpl;

import src.application.concert.service.ConcertService;
import src.domain.concert.entity.ConcertEntity;
import src.domain.concert.repository.ConcertRepository;
import src.domain.concert.repositoryimpl.ConcertRepositoryImpl;

public class ConcertServiceImpl  implements ConcertService {

    private ConcertRepository repo;

    public ConcertServiceImpl(ConcertRepository repo) {
        this.repo = repo;
    }

    @Override
    public ConcertEntity getConcert(String id) {
        return repo.getConcert(id);
    }
}
