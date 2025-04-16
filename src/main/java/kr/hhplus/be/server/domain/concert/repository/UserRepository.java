package kr.hhplus.be.server.domain.concert.repository;

import kr.hhplus.be.server.domain.concert.entity.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Balance, Long> {

    @Query("SELECT user_id, amount FROM Balance WHERE user_id = :user_id")
    Balance getBalance(long user_id);

    @Query("UPDATE Balance SET amount = :#{balance.amount} WHERE user_id = :#{balance.user_id}")
    @Modifying
    int setBalance(Balance balance);
}
