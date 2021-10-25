package delivery.com.service;

import delivery.com.domain.*;
import delivery.com.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final BasketService basketService;
    private final MemberService memberService;
    private final ShopService shopService;
    private final ItemService itemService;

    public void order(Long basketId) {
        Basket basket = basketService.findBasket(basketId);
        List<BasketItem> basketItems = basket.getBasketItems();

        List<OrderItem> orderItems = new ArrayList<>();
        for (BasketItem basketItem : basketItems) {
            orderItems.add(new OrderItem(basketItem.getItem(), basketItem.getCount()));
        }

        Order order = Order.createOrder(basket.getMember(), basket.getShop(), orderItems);
        orderRepository.save(order);
    }

    public Order findOrder(Long orderId) {
        return orderRepository.findById(orderId).orElseGet(null);
    }

    public List<Order> findByMemberId(Long memberId) {
        return orderRepository.findByMemberId(memberId);
    }

    public List<Order> findByShopId(Long shopId) {
        return orderRepository.findByShopId(shopId);
    }

    public List<Order> findAll() {
        return orderRepository.findOrderWithAll();
    }

}
