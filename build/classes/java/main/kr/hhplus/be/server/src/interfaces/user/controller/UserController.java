package src.interfaces.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import src.application.user.service.UserService;
import src.domain.user.entity.BalanceEntity;

import java.math.BigInteger;

@RestController
@RequestMapping({"/user"})
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping({"/{user_id}/balance"})
    public ResponseEntity<BalanceEntity> getBalance(@PathVariable BigInteger user_id) {

        if(user_id == null)
            throw new RuntimeException("concert_id is empty");

        return ResponseEntity.ok(userService.getBalance(user_id));
    }

    @PostMapping({"/{user_id}/balance"})
    public void setBalance(@RequestBody BigInteger user_id, @RequestBody long amount) {
        userService.setBalance(user_id, amount);
    }
}
