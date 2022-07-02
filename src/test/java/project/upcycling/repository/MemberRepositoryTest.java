package project.upcycling.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import project.upcycling.domain.Address;
import project.upcycling.domain.Member;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository;
    @PersistenceContext
    EntityManager em;

    @Test
    public void basicCRUD() throws Exception {
        //given
        Member member1 = new Member("yumin",
                new Address("주소주소", "우편우편", "상세상세"), "계좌계좌");
        memberRepository.save(member1);

        //이름 조회 검증
        List<Member> yumin = memberRepository.findByName("yumin");
        for (Member member : yumin) {
            System.out.println("member.getName() = " + member.getName());
            System.out.println("member.getAddress() = " + member.getAddress());
            System.out.println("member.getAccount() = " + member.getAccount());
        }
        Assertions.assertThat(yumin.size()).isEqualTo(2);
    }
}