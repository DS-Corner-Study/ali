package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

//회원레포지토리 구현체
public class MemoryMemberRepository implements MemberRepository {

    // 멤버 객체를 store 맵에 저장하고, 각 멤버에 고유한 식별자를 할당할 수 있도록 설계된 것
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }
    //ofNullable: null이면 빈 값의 optional 객체를 아니면 그 값의 optional객체를 뱉음

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny(); //먼저 찾은거 가져옴
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
