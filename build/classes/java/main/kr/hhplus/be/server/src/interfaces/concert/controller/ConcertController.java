package src.interfaces.concert.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import src.application.concert.service.ConcertService;
import src.domain.concert.entity.ConcertDateEntity;
import src.domain.concert.entity.ConcertEntity;
import src.domain.concert.entity.ConcertSeatEntity;
import src.domain.concert.entity.UserEntity;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping({"/concert"})
public class ConcertController {

    @Autowired
    private ConcertService concertService;

    public ConcertController(ConcertService service) {
        concertService = service;
    }

    @GetMapping({"/get"})
    public ResponseEntity<ConcertEntity> getConcert(String name) {
        return ResponseEntity.ok(concertService.getConcert(name));
    }

    @GetMapping({"/get/date/{concert_id}"})
    public ResponseEntity<List<ConcertDateEntity>> getDate(@PathVariable BigInteger concert_id, UserEntity user) {

        if(concert_id == null)
            throw new RuntimeException("concert_id is empty");

        return ResponseEntity.ok(concertService.getDate(concert_id, user));
    }

    @GetMapping({"/get/seat/{seat_id}"})
    public ResponseEntity<List<ConcertSeatEntity>> getSeat(@PathVariable BigInteger seat_id, UserEntity user) {

        if(seat_id == null)
            throw new RuntimeException("seat_id is empty");

        return ResponseEntity.ok(concertService.getSeat(seat_id, user));
    }

}
