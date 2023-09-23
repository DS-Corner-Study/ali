package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepositry memberRepositry;


    public MemberService(MemberRepositry memberRepositry) {
        this.memberRepositry = memberRepositry;
    } //memberrepository를 외부에서 가지고 오게 해서 같은 디비를 사용할 수 있게 한다

    //    회원가입
    public Long join(Member member){
//        같은 이름이 있는 중복 회원 안됨
        validateDuplicateMember(member); //중복 회원 검증

        memberRepositry.save(member);
        return member.getId();

    }

    private void validateDuplicateMember(Member member) {
        memberRepositry.findByName(member.getName())
                        .ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }
//전체회원 조회
    public List<Member> findMembers(){
        return memberRepositry.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepositry.findById(memberId);
    }
}
