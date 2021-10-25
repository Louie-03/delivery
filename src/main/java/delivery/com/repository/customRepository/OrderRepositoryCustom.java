package delivery.com.repository.customRepository;

import delivery.com.domain.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepositoryCustom {
    List<Order> findOrderWithAll();

    List<Order> findByMemberId(Long memberId);

    List<Order> findByShopId(Long shopId);
    List<Order> dynamicFindByMemberId(Long memberId);

}
