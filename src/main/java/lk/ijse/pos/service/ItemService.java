package lk.ijse.pos.service;

import lk.ijse.pos.dto.ItemDTO;
import lk.ijse.pos.entity.Item;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ItemService {
    List<Item> getAllItems();
    Item getItemById(Long id);
    Item saveItem(ItemDTO itemDTO);
    Item updateItem(ItemDTO itemDTO);
    Item deleteItem(Long id);
    List<Item> getItemByCategory(Long id);
}
