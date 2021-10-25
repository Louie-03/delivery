package delivery.com;

import delivery.com.domain.*;
import delivery.com.repository.*;
import delivery.com.service.InterestShopService;
import delivery.com.service.ShopService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
@Rollback(value = false)
class ComApplicationTests {

	@Autowired EntityManager em;
	@Autowired BasketRepository basketRepository;
	@Autowired
	InterestShopService interestShopService;
	@Autowired ShopRepository shopRepository;
	@Autowired InterestShopRepository interestShopRepository;
	@Autowired OrderRepository orderRepository;
	@Autowired
	ShopService shopService;
	@Autowired ItemRepository itemRepository;
	@Autowired MemberRepository memberRepository;
	@Autowired ReviewRepository reviewRepository;
	@Autowired
	ShopCategoryRepository shopCategoryRepository;
	@Autowired
	ShopCategoryDetailRepository shopCategoryDetailRepository;

	@Test
	void contextLoads() {
		Shop shop = shopService.findShop(16L);
		Member member = new Member(null);
		OrderItem orderItem = new OrderItem(new Item("iiii", 10000), 3);
		OrderItem orderItem2 = new OrderItem(new Item("iiiii", 20000), 3);
		List<OrderItem> arrayList = new ArrayList<>();
		arrayList.add(orderItem);
		arrayList.add(orderItem2);
		Order order = Order.createOrder(member, shop, arrayList);
		Review re = new Review("re", 3L);
		order.setReview(re);
		em.persist(member);
		em.persist(shop);
		em.persist(re);
		em.persist(order);

		em.flush();
		em.clear();

	}

	@Test
	void a() {
		ShopCategoryDetail shopCategoryDetail = em.find(ShopCategoryDetail.class, 24L);
		System.out.println("shopCategoryDetail.getShop().getId() = " + shopCategoryDetail.getShop().getId());
		System.out.println("shopCategoryDetail.getShopCategory().getId() = " + shopCategoryDetail.getShopCategory().getId());
	}

	@Test
	void b() {

	}
}
