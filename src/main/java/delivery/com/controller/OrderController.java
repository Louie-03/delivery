package delivery.com.controller;

import delivery.com.repository.OrderRepository;
import delivery.com.service.MemberService;
import delivery.com.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepository orderRepository;
    private final OrderService orderService;
    private final MemberService memberService;

    @PostMapping("/orders/new")
    public String createOrder(Long basketId) {
        orderService.order(basketId);
        return "redirect:/orders";
    }

    @GetMapping("/orders")
    public String orders(Model model, Long memberId) {
        model.addAttribute("orders", orderRepository.dynamicFindByMemberId(memberId));
        model.addAttribute("members", memberService.findAll());
        return "order/orders";
    }
}
