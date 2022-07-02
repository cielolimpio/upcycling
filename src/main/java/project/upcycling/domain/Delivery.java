package project.upcycling.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static project.upcycling.domain.DeliveryStatus.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Delivery {

    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    private DeliveryStatus deliveryStatus;

    @Embedded
    private Address address;

    public Delivery(Address address) {
        deliveryStatus = FUNDING;
        this.address = address;
    }
}
