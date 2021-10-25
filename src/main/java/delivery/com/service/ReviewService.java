package delivery.com.service;

import delivery.com.domain.Order;
import delivery.com.domain.Review;
import delivery.com.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final OrderService orderService;

    public Double findScoreAvgByShopId(Long shopId) {
       return reviewRepository.findAvgScoreByShopId(shopId);
    }

    public Long findCountByShopId(Long shopId) {
        return reviewRepository.findCountByShopId(shopId);
    }

    @Transactional
    public void save(Long orderId, String text, int score) {
        Review review = new Review(text, score);
        reviewRepository.save(review);
        Order order = orderService.findOrder(orderId);
        order.setReview(review);
    }
}
