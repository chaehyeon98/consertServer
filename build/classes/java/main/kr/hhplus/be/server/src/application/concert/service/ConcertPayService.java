package src.application.concert.service;

import src.domain.concert.entity.ReservationEntity;
import src.domain.concert.entity.UserEntity;

public interface ConcertPayService {

    ReservationEntity pay(UserEntity user, ReservationEntity reservation);
}
