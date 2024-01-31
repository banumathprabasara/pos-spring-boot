package lk.ijse.pos.service.impl;

import lk.ijse.pos.dto.ItemDTO;
import lk.ijse.pos.entity.Item;
import lk.ijse.pos.entity.ItemCategory;
import lk.ijse.pos.repository.CategoryRepository;
import lk.ijse.pos.repository.ItemRepository;
import lk.ijse.pos.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    @Override
    public Item saveItem(ItemDTO itemDTO) {
        ItemCategory itemCategory = categoryRepository.findById(itemDTO.getCat_id()).orElse(null);

        if (itemCategory != null) {
            Item item = new Item();
            item.setName(itemDTO.getName());
            item.setCode(itemDTO.getId());
            item.setUnitPrice(itemDTO.getUnitPrice());
            item.setQtyOnHand(itemDTO.getQtyOnHand());
            item.setCategory(itemCategory);
            return itemRepository.save(item);
        } else {
            return null;
        }
    }

    @Override
    public Item updateItem(ItemDTO itemDTO) {
        Item item = itemRepository.findById(itemDTO.getId()).orElse(null);
        if (item != null) {
            item.setName(itemDTO.getName());
            item.setUnitPrice(itemDTO.getUnitPrice());
            item.setQtyOnHand(itemDTO.getQtyOnHand());
            return itemRepository.save(item);
        } else {
            return null;
        }
    }

    @Override
    public Item deleteItem(Long id) {
        Item item=itemRepository.findById(id).orElse(null);
        if(item!=null){
            itemRepository.delete(item);
            return item;
        }else {
            return null;
        }
    }

    @Override
    public List<Item> getItemByCategory(Long id) {
        ItemCategory category = categoryRepository.findById(id).orElse(null);

        if(category != null) {
            return itemRepository.findProductsByCategory(category);
        } else {
            return null;
        }
    }
}
