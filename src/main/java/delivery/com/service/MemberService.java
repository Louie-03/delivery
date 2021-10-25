package delivery.com.service;

import delivery.com.domain.Member;
import delivery.com.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void join(Member member) {
        memberRepository.save(member);
    }

    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId).orElseGet(null);
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

}
