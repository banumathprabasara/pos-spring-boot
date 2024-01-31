package lk.ijse.pos.service;

import lk.ijse.pos.dto.ItemCatDTO;
import lk.ijse.pos.entity.ItemCategory;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CategoryService {
    List<ItemCategory> getCategories();
    ItemCategory getCategoriesById(Long id);
    ItemCategory saveCategory(ItemCatDTO itemCatDTO);
    ItemCategory updateCategory(ItemCatDTO itemCatDTO);
    ItemCategory deleteCategory(Long id);
}
