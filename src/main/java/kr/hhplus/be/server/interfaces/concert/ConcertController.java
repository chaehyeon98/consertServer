package kr.hhplus.be.server.interfaces.concert;

import kr.hhplus.be.server.application.concert.Facade.ConcertFacade;
import kr.hhplus.be.server.domain.concert.entity.*;
import kr.hhplus.be.server.domain.concert.service.ConcertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/concert"})
public class ConcertController {

    @Autowired
    private ConcertService concertService;

    @Autowired
    private ConcertFacade concertFacade;

    public ConcertController(ConcertService service) {
        concertService = service;
    }

    @GetMapping({"/get"})
    public ResponseEntity<List<Concert>> getConcert() {
        return ResponseEntity.ok(concertService.getConcert());
    }

    @GetMapping({"/get/date/{concert_id}"})
    public ResponseEntity<List<ConcertDate>> getDate(@PathVariable long concert_id, User user) {

        if(concert_id == 0)
            throw new RuntimeException("concert_id is empty");

        return ResponseEntity.ok(concertService.getDate(concert_id, user));
    }

    @GetMapping({"/get/seat/{concert_date_id}"})
    public ResponseEntity<List<ConcertSeat>> getSeat(@PathVariable long concert_date_id, User user) {

        if(concert_date_id == 0)
            throw new RuntimeException("concert_date_id is empty");

        return ResponseEntity.ok(concertFacade.getSeatList(user, concert_date_id));
    }

    @PostMapping({"/reservation"})
    public ResponseEntity<Reservation>  getReservation(@RequestBody User user, long seat_id) {
        return ResponseEntity.ok(concertFacade.getReservation(user, seat_id));
    }


}