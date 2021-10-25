package delivery.com.repository;

import delivery.com.domain.Order;
import delivery.com.domain.Review;
import delivery.com.repository.customRepository.OrderRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long>, OrderRepositoryCustom {
}
