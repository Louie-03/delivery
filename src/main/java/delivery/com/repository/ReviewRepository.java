package delivery.com.repository;

import delivery.com.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query("select coalesce(avg(r.score), 0) from Order o join o.review r where o.shop.id = :shopId")
    Double findAvgScoreByShopId(@Param("shopId") Long shopId);

    @Query("select count(r) from Order o join o.review r where o.shop.id = :shopId")
    Long findCountByShopId(@Param("shopId") Long shopId);

}
