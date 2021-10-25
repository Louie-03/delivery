package delivery.com.service;

import delivery.com.domain.InterestShop;
import delivery.com.domain.Member;
import delivery.com.domain.Shop;
import delivery.com.repository.InterestShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InterestShopService {

    private final InterestShopRepository interestShopRepository;
    private final MemberService memberService;
    private final ShopService shopService;

    public void save(Long memberId, Long shopId) {
        Member member = memberService.findMember(memberId);
        Shop shop = shopService.findShop(shopId);
        InterestShop interestShop = new InterestShop(member, shop);

        interestShopRepository.save(interestShop);
    }

    public void delete(Long interestShopId) {
        InterestShop interestShop = findInterestShop(interestShopId);
        interestShopRepository.delete(interestShop);
    }

    public List<InterestShop> findByMemberId(Long memberId) {
//        return interestShopRepository.findByMemberId(memberId);
        return null;
    }

    public Long findCountByShopId(Long shopId) {
        return interestShopRepository.findCountByShopId(shopId);
    }

    public InterestShop findInterestShop(Long interestShopId) {
        return interestShopRepository.findById(interestShopId).orElseGet(null);
    }
}
