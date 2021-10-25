package delivery.com.controller;

import delivery.com.repository.InterestShopRepository;
import delivery.com.service.InterestShopService;
import delivery.com.service.MemberService;
import delivery.com.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class InterestShopController {

    private final InterestShopService interestShopService;
    private final InterestShopRepository interestShopRepository;
    private final MemberService memberService;
    private final ReviewService reviewService;

    @GetMapping("/interestShops")
    public String interestShops(Model model, Long memberId) {
        model.addAttribute("members", memberService.findAll());
        List<InterestShopDto> dtoList = interestShopRepository.findAllNameByMemberId(memberId);
        for (InterestShopDto interestShopDto : dtoList) {
            Long shopId = interestShopDto.getShopId();
            interestShopDto.setReviewAvg(reviewService.findScoreAvgByShopId(shopId));
            interestShopDto.setReviewCount(reviewService.findCountByShopId(shopId));
        }
        model.addAttribute("interestShopDtos", dtoList);
        return "interestShop/interestShopList";
    }
}
