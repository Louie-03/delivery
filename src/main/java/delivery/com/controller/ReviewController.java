package delivery.com.controller;

import delivery.com.domain.Review;
import delivery.com.domain.Shop;
import delivery.com.repository.ReviewRepository;
import delivery.com.service.OrderService;
import delivery.com.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;
    private final OrderService orderService;

    @GetMapping("/reviews/new")
    public String createReviewForm() {
        return "review/reviewForm";
    }

    @PostMapping("/reviews/new")
    public String createReview(Long orderId, String text, int score) {
        reviewService.save(orderId, text, score);
        return "redirect:/orders";
    }
}
