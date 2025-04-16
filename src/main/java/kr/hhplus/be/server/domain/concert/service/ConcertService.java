package kr.hhplus.be.server.domain.concert.service;

import kr.hhplus.be.server.domain.concert.entity.Concert;
import kr.hhplus.be.server.domain.concert.entity.ConcertDate;
import kr.hhplus.be.server.domain.concert.entity.User;

import java.util.List;

public interface ConcertService {

    List<Concert> getConcert();

    List<ConcertDate> getDate(long concertId, User user);
}
