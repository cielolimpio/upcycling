package project.upcycling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.upcycling.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
