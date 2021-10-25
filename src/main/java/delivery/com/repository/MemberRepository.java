package delivery.com.repository;

import delivery.com.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Override
    @Query("select m from Member m join fetch m.basket")
    List<Member> findAll();
}
