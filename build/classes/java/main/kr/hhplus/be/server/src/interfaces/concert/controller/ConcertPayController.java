package src.interfaces.concert.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import src.application.concert.service.ConcertPayService;
import src.domain.concert.entity.ReservationEntity;
import src.domain.concert.entity.UserEntity;


@RestController
@RequestMapping({"/pay"})
public class ConcertPayController {

    @Autowired
    private ConcertPayService concertPayService;

    public ConcertPayController(ConcertPayService concertPayService) {
        this.concertPayService = concertPayService;
    }
    @PostMapping({"/reservation"})
    public ResponseEntity<ReservationEntity> pay(@RequestBody UserEntity user, ReservationEntity reservation) {
        return ResponseEntity.ok(concertPayService.pay(user, reservation));
    }
}
