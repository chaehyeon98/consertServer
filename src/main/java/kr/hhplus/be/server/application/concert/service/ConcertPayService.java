package kr.hhplus.be.server.application.concert.service;


import kr.hhplus.be.server.domain.concert.entity.ReservationEntity;
import kr.hhplus.be.server.domain.concert.entity.UserEntity;

public interface ConcertPayService {

    ReservationEntity pay(UserEntity user, ReservationEntity reservation);
}
