package delivery.com.repository;

import delivery.com.domain.InterestShop;
import delivery.com.repository.customRepository.InterestShopRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InterestShopRepository extends JpaRepository<InterestShop, Long>, InterestShopRepositoryCustom {

    @Query("select count(i) from InterestShop i where i.shop.id = :shopId")
    Long findCountByShopId(@Param("shopId") Long shopId);
}
