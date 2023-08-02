package myshop.firstshop.service;

import myshop.firstshop.domain.Member;
import myshop.firstshop.domain.MemberDto;
import org.assertj.core.api.Assertions;
import org.hibernate.annotations.ManyToAny;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

class MemberServiceTest {

    @Autowired MemberService memberService;
    @Test
    @Transactional
    void save(){
        //given
        Member member = new Member("MemberA", "abc123", "1q2w3e4r", LocalDateTime.now(), "01077558844", "ema@gmail.com");

        //when
        Long join = memberService.join(member);

        //then
        Member memberFind = memberService.findById(join).get();
        Assertions.assertThat(memberFind).isEqualTo(member);
    }

    @Test
    @Transactional
    void update(){
        //given
        Member member = new Member("MemberA", "abc123", "1q2w3e4r", LocalDateTime.now(), "01077558844", "ema@gmail.com");
        Long join = memberService.join(member);

        //when
        Member updateMember = memberService.findById(join).get();
        memberService.update(updateMember.getId(),new MemberDto("MemberB", "11223344", LocalDateTime.now(), "01011112222","em@naver.com"));

        //then
        Assertions.assertThat(member.getName()).isEqualTo("MemberB");

    }

    @Test
    void delete(){
        //given
        Member member = new Member("MemberA", "abc123", "1q2w3e4r", LocalDateTime.now(), "01077558844", "ema@gmail.com");
        Long join = memberService.join(member);

        //when
        Member findId = memberService.findById(join).get();
        memberService.delete(findId.getId());

        //then
        List<Member> findALl = memberService.findAll();
        Assertions.assertThat(findALl.size()).isEqualTo(0);
    }


}