package myshop.firstshop.service;

import jakarta.persistence.Entity;
import lombok.RequiredArgsConstructor;
import myshop.firstshop.domain.Member;
import myshop.firstshop.domain.MemberDto;
import myshop.firstshop.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    // 회원가입
    @Transactional
    public Long join(Member member){
        Member save = memberRepository.save(member);
        return save.getId();
    }

    // 목록 출력
    public List<Member> memberList(){
        return memberRepository.findAll();
    }

   // 아이디 찾기
   public Optional<Member> findById(Long id){
        return memberRepository.findById(id);
   }

   //업데이트
   @Transactional
    public void update(Long id, MemberDto memberDto){
        // 예외 처리
        Optional<Member> findId = memberRepository.findById(id);

        // 값이 있는지 없는지 확인
        if(findId.isPresent()){
            Member member = memberRepository.findById(id).get();
            member.update(memberDto);
        } else{
            throw new NoSuchElementException("No Found Id : "+ id);
        }
    }

    // 삭제
    @Transactional
    public void delete(Long id){
        memberRepository.deleteById(id);
    }

    public List<Member> findAll(){
        return memberRepository.findAll();
    }

}
