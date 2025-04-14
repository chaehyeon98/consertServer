package kr.hhplus.be.server.application.concert.service;


import kr.hhplus.be.server.domain.concert.entity.Reservation;
import kr.hhplus.be.server.domain.concert.entity.User;

public interface ConcertPayService {

    Reservation pay(User user, Reservation reservation);
}
