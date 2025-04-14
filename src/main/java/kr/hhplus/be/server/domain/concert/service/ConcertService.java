package domain.concert.service;

import domain.concert.entity.Concert;
import domain.concert.entity.ConcertDate;
import domain.concert.entity.User;

import java.math.BigInteger;
import java.util.List;

public interface ConcertService {

    List<Concert> getConcert(String name);

    List<ConcertDate> getDate(BigInteger concertId, User user);
}
