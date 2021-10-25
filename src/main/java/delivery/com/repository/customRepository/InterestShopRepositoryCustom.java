package delivery.com.repository.customRepository;

import delivery.com.controller.InterestShopDto;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InterestShopRepositoryCustom {

    List<InterestShopDto> findAllNameByMemberId(@Param("memberId") Long memberId);
}
