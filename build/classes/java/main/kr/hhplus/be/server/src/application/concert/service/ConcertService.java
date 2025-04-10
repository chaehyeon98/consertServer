package src.application.concert.service;

import src.domain.concert.entity.ConcertEntity;

public interface ConcertService {

    ConcertEntity getConcert(String id);
}
