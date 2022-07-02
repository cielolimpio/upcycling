package project.upcycling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.upcycling.domain.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
