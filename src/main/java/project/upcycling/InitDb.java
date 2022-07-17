package project.upcycling;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import project.upcycling.domain.*;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.time.LocalDate;

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

            Member member1 = new Member("email1", "pw1", "ddongssu");
            Member member2 = new Member("email2", "pw2", "hanjoongyu");
            Member member3 = new Member("email3", "pw3", "yumin");

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
