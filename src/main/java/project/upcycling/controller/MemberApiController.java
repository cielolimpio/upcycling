package project.upcycling.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import project.upcycling.domain.Member;
import project.upcycling.dto.CreateMemberRequest;
import project.upcycling.dto.ResponseDto;
import project.upcycling.service.MemberService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/auth/join")
    public ResponseDto<Long> saveMember (@RequestBody @Valid CreateMemberRequest request) {

        Member member = new Member(request.getEmail(), request.getPassword(), request.getName());

        Long id = memberService.join(member);

        return new ResponseDto<>(HttpStatus.OK.value(), id);
    }

}
