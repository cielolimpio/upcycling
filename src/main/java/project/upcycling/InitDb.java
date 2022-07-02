package project.upcycling;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import project.upcycling.domain.*;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static project.upcycling.domain.Category.*;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.dbInit();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {

        private final EntityManager em;
        public void dbInit() {

            Member member1 = new Member("ddongssu",
                    new Address("주소1", "우편1", "상세1"),
                    "계좌번호1");
            Member member2 = new Member("hanjoongyoo",
                    new Address("주소2", "우편2", "상세2"),
                    "계좌번호2");
            Member member3 = new Member("yumin",
                    new Address("주소3", "우편3", "상세3"),
                    "계좌번호3");

            em.persist(member1);
            em.persist(member2);
            em.persist(member3);

            Item item1 = new Item(
                    "가구1", 20000, "url1",
                    LocalDate.of(2022, 7, 24),
                    50000, "content1", FURNITURE, member1);

            em.persist(item1);

            Order order1 = new Order(40000, 2, member2, item1);

            em.persist(order1);
        }
    }
}
