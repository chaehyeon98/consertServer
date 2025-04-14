package interfaces.concert;

import application.concert.Facade.ConcertFacade;
import domain.concert.entity.*;
import domain.concert.service.ConcertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
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
    public ResponseEntity<List<Concert>> getConcert(String name) {
        return ResponseEntity.ok(concertService.getConcert(name));
    }

    @GetMapping({"/get/date/{concert_id}"})
    public ResponseEntity<List<ConcertDate>> getDate(@PathVariable BigInteger concert_id, User user) {

        if(concert_id == null)
            throw new RuntimeException("concert_id is empty");

        return ResponseEntity.ok(concertService.getDate(concert_id, user));
    }

    @GetMapping({"/get/seat/{concert_date_id}"})
    public ResponseEntity<List<ConcertSeat>> getSeat(@PathVariable BigInteger concert_date_id, User user) {

        if(concert_date_id == null)
            throw new RuntimeException("concert_date_id is empty");

        return ResponseEntity.ok(concertFacade.getSeatList(user, concert_date_id));
    }

    @PostMapping({"/reservation"})
    public ResponseEntity<Reservation>  getReservation(@RequestBody User user, BigInteger seat_id) {
        return ResponseEntity.ok(concertFacade.getReservation(user, seat_id));
    }


}