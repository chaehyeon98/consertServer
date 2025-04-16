package kr.hhplus.be.server.domain.concert.repository;

import kr.hhplus.be.server.domain.concert.entity.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ConcertPayRepository extends JpaRepository<Balance, Long> {

    @Modifying
    @Query("UPDATE Balance SET amount = :#{balanceEntity.amount} WHERE user_id = :#{balanceEntity.user_id}")
    int updateBalance(Balance balanceEntity);



}
