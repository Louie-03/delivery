package delivery.com.repository;

import delivery.com.domain.Shop;
import delivery.com.domain.ShopCategory;
import delivery.com.domain.ShopCategoryDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShopCategoryRepository extends JpaRepository<ShopCategory, Long> {

}
