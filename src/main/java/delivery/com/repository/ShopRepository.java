package delivery.com.repository;

import delivery.com.domain.Shop;
import delivery.com.repository.customRepository.ShopRepositoryCustom;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShopRepository extends JpaRepository<Shop, Long>, ShopRepositoryCustom {

    @Query("select s from ShopCategoryDetail scd join scd.shop s where scd.shopCategory.id = :id")
    List<Shop> findByShopCategoryId(@Param("id") Long id);


}
