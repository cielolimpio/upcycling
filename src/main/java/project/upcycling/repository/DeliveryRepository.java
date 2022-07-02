package project.upcycling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.upcycling.domain.Delivery;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}
