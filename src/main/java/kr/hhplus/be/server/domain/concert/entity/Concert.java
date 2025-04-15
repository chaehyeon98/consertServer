package domain.concert.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Concert")
public class Concert {

    @Id
    private long concert_id;

    @Column(nullable = false)
    private String concert_name;


    public Concert(long concert_id, String concert_name) {
        this.concert_id = concert_id;
        this.concert_name = concert_name;
    }

    public Concert() {

    }
}
