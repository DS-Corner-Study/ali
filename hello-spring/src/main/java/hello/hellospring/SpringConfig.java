package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

//    private DataSource dataSource;
//    private EntityManager em;
//
//    public SpringConfig(DataSource dataSource, EntityManager em){
//        this.dataSource = dataSource;
//        this.em = em;
//    }
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

    //이거 아니면 컴포넌트 스캔 쓰면 되는데 여기선 컴포넌트 스캔을 쓴데
//    @Bean
//   public TimeTraceAop timeTraceAop(){
//        return timeTraceAop();
//    }


//    @Bean
//    public MemberRepositry memberRepositry(){
//        //return new MemoryMemberRepository();
//        //return new JdbcMemberRepository(dataSource);
//        //return new JdbcTemplatememberRepository(dataSource);
//        //return new JpaMemberRepository(em);
//        //return new dbMemoryMemberRepository(); 나중에
//    }
}
