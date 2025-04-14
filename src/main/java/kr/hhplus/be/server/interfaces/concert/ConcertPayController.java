package interfaces.concert;

import application.concert.Facade.ConcertFacade;
import domain.concert.entity.Reservation;
import domain.concert.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping({"/pay"})
public class ConcertPayController {

    @Autowired
    private ConcertFacade concertFacade;

    public ConcertPayController(ConcertFacade concertFacade) {
        this.concertFacade = concertFacade;
    }
    @PostMapping({"/reservation"})
    public void pay(@RequestBody User user, Reservation reservation) {
        concertFacade.pay(user, reservation);
    }
}