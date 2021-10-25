package delivery.com.controller;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InterestShopDto {

    private Long shopId;
    private String shopName;
    private String memberName;
    private Double reviewAvg;
    private Long reviewCount;

    @QueryProjection
    public InterestShopDto(Long shopId, String shopName, String memberName) {
        this.shopId = shopId;
        this.shopName = shopName;
        this.memberName = memberName;
    }
}
