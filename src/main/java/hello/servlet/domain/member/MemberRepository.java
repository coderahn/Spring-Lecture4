package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {
    //static으로 MemberRespository 인스턴스 생성이 계속 되어도 1개만 생성
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; //ID 시퀀스

    private static final MemberRepository instance = new MemberRepository();

    //싱글톤으로 만들기 때문에 위에 store의 static은 빼도 상관없으나 그냥 static 처리
    public static MemberRepository getInstance() {
        return instance;
    }

    private MemberRepository() {
    }

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
