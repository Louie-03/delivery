package delivery.com.repository;

import delivery.com.domain.Basket;
import delivery.com.repository.customRepository.BasketRepositoryCustom;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BasketRepository extends JpaRepository<Basket, Long>, BasketRepositoryCustom {

    @Override
    @Query("select b from Basket b join fetch b.member join fetch b.basketItems bi join fetch bi.item")
    Optional<Basket> findById(Long aLong);

    @Query("select b from Basket b where b.member.id = :memberId")
    Basket findByMemberId(@Param("memberId") Long memberId);

}
