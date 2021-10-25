package delivery.com.repository.customRepository;

import delivery.com.controller.BasketDto;

public interface BasketRepositoryCustom {
    BasketDto findDtoToItemByMemberId(Long memberId);
}
