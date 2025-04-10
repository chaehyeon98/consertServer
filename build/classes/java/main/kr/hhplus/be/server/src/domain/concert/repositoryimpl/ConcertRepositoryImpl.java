package src.domain.concert.repositoryimpl;

import org.springframework.stereotype.Repository;
import src.domain.concert.entity.ConcertEntity;
import src.domain.concert.repository.ConcertRepository;

@Repository
public class ConcertRepositoryImpl implements ConcertRepository {
    @Override
    public ConcertEntity getConcert(String id) {
        return null;
    }
}
