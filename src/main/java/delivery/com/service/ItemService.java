package delivery.com.service;

import delivery.com.domain.Item;
import delivery.com.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public Item findItem(Long itemId) {
        return itemRepository.findById(itemId).orElseGet(null);
    }

    public List<Item> findItems(List<Long> itemIds) {
        return itemRepository.findAllById(itemIds);
    }
}
