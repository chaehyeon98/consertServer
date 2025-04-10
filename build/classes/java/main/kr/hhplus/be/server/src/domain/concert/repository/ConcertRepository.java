package src.domain.concert.repository;

import src.domain.concert.entity.ConcertEntity;

public interface ConcertRepository {
    ConcertEntity getConcert(String id);
}
