package hello.hellospring;

import hello.hellospring.repository.MemberRepositry;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepositry());
    }

    @Bean
    public MemberRepositry memberRepositry(){
        return new MemoryMemberRepository();
        //return new dbMemoryMemberRepository(); 나중에
    }
}
