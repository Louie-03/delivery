package delivery.com.repository;

import delivery.com.domain.Item;
import delivery.com.repository.customRepository.ShopRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
