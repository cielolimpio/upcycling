package project.upcycling.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@SpringBootTest
@Transactional
@Rollback(value = false)
public class EntityTest {

    @PersistenceContext
    EntityManager em;

//    @Test
//    public void testEntity() throws Exception {
//        //given
//        Member member1 = new Member("ddongssu",
//                new Address("주소1", "우편1", "상세1"),
//                "계좌번호1");
//        Member member2 = new Member("hanjoongyoo",
//                new Address("주소2", "우편2", "상세2"),
//                "계좌번호2");
//
//        //when
//        em.persist(member1);
//        em.persist(member2);
//
//        em.flush();
//        em.clear();
//        //then
//        List<Member> members = em.createQuery("select m from Member m", Member.class)
//                .getResultList();
//
//        for (Member member : members) {
//            System.out.println("member.getName() = " + member.getName());
//        }
//    }
}
