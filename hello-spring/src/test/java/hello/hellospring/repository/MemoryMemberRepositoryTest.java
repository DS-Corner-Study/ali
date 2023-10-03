package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repositry = new MemoryMemberRepository();
    @AfterEach //작동될 때마다 디비의 내용을 삭제해 한번에 테스트 가능
    public void afterEach(){
        repositry.clearStore();
    }
    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repositry.save(member);
        Member result = repositry.findById(member.getId()).get();

        //System.out.printf("result="+(result==member));
        //Assertions.assertEquals(result, member);
        assertThat(member).isEqualTo(result);

    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repositry.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repositry.save(member2);

        Member result = repositry.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repositry.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repositry.save(member2);

        List<Member> result = repositry.findAll();
        assertThat(result.size()).isEqualTo(2);
    }

}
