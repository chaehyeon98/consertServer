package src.interfaces.concert.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import src.application.concert.service.ConcertService;
import src.domain.concert.entity.ConcertEntity;

@RestController
@RequestMapping({"/concert"})
public class ConcertController {

    @Autowired
    private ConcertService concertService;

    public ConcertController(ConcertService service) {
        concertService = service;
    }

    @GetMapping({"/get"})
    public ResponseEntity<ConcertEntity> getConcert(@PathVariable String id) {
        return ResponseEntity.ok(concertService.getConcert(id));
    }

}
