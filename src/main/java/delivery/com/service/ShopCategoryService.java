package delivery.com.service;

import delivery.com.domain.ShopCategory;
import delivery.com.repository.ShopCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopCategoryService {

    private final ShopCategoryRepository shopCategoryRepository;

    public List<ShopCategory> findAll() {
        return shopCategoryRepository.findAll();
    }


}
