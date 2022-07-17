package project.upcycling.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.upcycling.domain.Member;
import project.upcycling.repository.MemberRepository;

import javax.persistence.Tuple;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

//    @Autowired
//    private PasswordEncoder encoder;

    public Long join (Member member) {
        boolean isValidEmail = validateDuplicateEmail(member);
        if (isValidEmail) {
//            String rawPassword = member.getPassword();
//            String encodedPassword = encoder.encode(rawPassword);
//
//            member.setPassword(encodedPassword);

            memberRepository.save(member);
            return member.getId();
        } else return null;

    }

    private boolean validateDuplicateEmail(Member member) {
        Member findMember = memberRepository.findByEmail(member.getEmail());
        if (findMember != null) {
            return false;
        } else return true;
    }
}
