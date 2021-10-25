package delivery.com;

import delivery.com.domain.*;
import delivery.com.repository.ShopCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class InitDb {

    private final InitService initService;

    @PostConstruct
    public void init() throws IOException {
        initService.init();
    }

    @RequiredArgsConstructor
    @Component
    @Transactional
    static class InitService {

        private final EntityManager em;
        private final ShopCategoryRepository shopCategoryRepository;

        public void init() throws IOException {
            List<ShopCategory> shopCategoryList = createShopCategories();
            List<String> shopNameList1 = createShopNameList1();
            ShopCategory shopCategory = shopCategoryList.get(0);
            System.out.println("shopCategory.getId() = " + shopCategory.getId());
            System.out.println("shopCategory.getName() = " + shopCategory.getName());
            addShopCategoryDetail(shopCategory, shopNameList1);

            shopCategoryRepository.saveAll(shopCategoryList);

            em.persist(new Member("memberA"));
            em.persist(new Member("memberB"));
            em.persist(new Member("memberC"));
            em.persist(new Member("memberD"));
            em.persist(new Member("memberE"));

            Shop shop = new Shop("국밥");
            Shop shop2 = new Shop("국밥2");

            for (int i = 1; i < 4; i++) {
                ItemCategory itemCategory = new ItemCategory(shop, "카테고리" + i);
                ItemCategory itemCategory2 = new ItemCategory(shop2, "카테고리" + i);
                for (int j = 1; j < 6; j++) {
                    em.persist(new ItemCategoryDetail(itemCategory, new Item("음식" + ((i-1) * 5 + j), ((i-1) * 5 + j) * 1000)));
                    em.persist(new ItemCategoryDetail(itemCategory2, new Item("음식" + ((i-1) * 5 + j), ((i-1) * 5 + j) * 1000)));
                }
            }
        }

        private List<String> createShopNameList1() {
            List<String> shopNameList1 = new ArrayList<>();
            shopNameList1.add("파스타입니다-마석점");
            shopNameList1.add("1인한식당-마석점");
            shopNameList1.add("수유리혼밥왕-마석점");
            shopNameList1.add("호시타코야끼-마석점");
            shopNameList1.add("뼈대있는국밥-마석점");
            shopNameList1.add("롯데리아-남양주화도D/T점");
            shopNameList1.add("요녀석파스타&필라프-화도점");
            shopNameList1.add("냉면덕후-마석점");
            shopNameList1.add("쩡아돈가스");
            shopNameList1.add("봄밀과자점");
            shopNameList1.add("소문난닭강정-마석점");
            shopNameList1.add("떡깨비-마석우리점");
            shopNameList1.add("오늘은카레-남양화도점");
            shopNameList1.add("커피공방카페리퀴드");
            shopNameList1.add("통큰남산왕돈까스&육쌈냉면");
            shopNameList1.add("본죽앤비빔밥-남양주마석점");
            shopNameList1.add("호시타코야끼-마석점");
            shopNameList1.add("가마치통닭-마석점");
            shopNameList1.add("1번지통닭-마석점");
            shopNameList1.add("꾸꾸닥-마석직영점");
            shopNameList1.add("성윤국가대표아구찜앤알곤이찜-마석점");
            shopNameList1.add("마석닭강정-본점");
            shopNameList1.add("찬's닭강정");
            shopNameList1.add("찬스닭강정");
            shopNameList1.add("코리엔탈깻잎두마리치킨-마석점");
            shopNameList1.add("김가닭강정-화도점");
            shopNameList1.add("무지개우유");
            shopNameList1.add("뚱스치킨-남양주점");
            shopNameList1.add("돈가네혼밥");
            return shopNameList1;
        }

        private void addShopCategoryDetail(ShopCategory shopCategory, List<String> shopNameList) {
            for (String shopName : shopNameList) {
                System.out.println("shopCategory = " + shopCategory);
                System.out.println("shopName = " + shopName);
                em.persist(new ShopCategoryDetail(new Shop(shopName), shopCategory));
            }
        }

        private List<ShopCategory> createShopCategories() {
            List<ShopCategory> shopCategories = new ArrayList<>();
            shopCategories.add(new ShopCategory("1인분"));
            shopCategories.add(new ShopCategory("한식"));
            shopCategories.add(new ShopCategory("분식"));
            shopCategories.add(new ShopCategory("카페/디저트"));
            shopCategories.add(new ShopCategory("일식"));
            shopCategories.add(new ShopCategory("치킨"));
            shopCategories.add(new ShopCategory("피자"));
            shopCategories.add(new ShopCategory("중국집"));
            shopCategories.add(new ShopCategory("족발/보쌈"));
            shopCategories.add(new ShopCategory("야식"));
            shopCategories.add(new ShopCategory("찜/탕"));
            shopCategories.add(new ShopCategory("도시락"));
            shopCategories.add(new ShopCategory("패스트푸드"));
            return shopCategories;
        }

    }
}
