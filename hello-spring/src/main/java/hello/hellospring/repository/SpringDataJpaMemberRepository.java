package hello.hellospring.repository;
import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
   //JPOL select m from Member m where m.name=? => 규칙이 있어서 인터페이스 이름만으로 구현됨
    @Override
    Optional<Member> findByName(String name);
}
