package kr.hhplus.be.server.domain.concert.repository;

import kr.hhplus.be.server.domain.concert.entity.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BalanceRepository extends JpaRepository<Balance, Long> {

    @Query("SELECT b FROM Balance b WHERE b.user_id = :user_id")
    Balance getBalance(@Param("user_id") long user_id);

    @Query("UPDATE Balance b SET b.amount = :amount WHERE b.user_id = :user_id")
    @Modifying
    @Transactional
    int setBalance(@Param("user_id") long userId, @Param("amount") long amount);
}
