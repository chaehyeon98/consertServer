package kr.hhplus.be.server.interfaces.concert;

import kr.hhplus.be.server.application.concert.Facade.ConcertFacade;
import kr.hhplus.be.server.domain.concert.entity.Reservation;
import kr.hhplus.be.server.domain.concert.entity.User;
import kr.hhplus.be.server.domain.concert.service.ConcertPayService;
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