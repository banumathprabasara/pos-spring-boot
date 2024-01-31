package lk.ijse.pos.service.impl;

import lk.ijse.pos.dto.ItemCatDTO;
import lk.ijse.pos.entity.ItemCategory;
import lk.ijse.pos.repository.CategoryRepository;
import lk.ijse.pos.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<ItemCategory> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public ItemCategory getCategoriesById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public ItemCategory saveCategory(ItemCatDTO itemCatDTO) {
        ItemCategory itemCategory=categoryRepository.findById(itemCatDTO.getCatId()).orElse(null);

        if (itemCategory==null) {
            ItemCategory newItem = new ItemCategory();
            newItem.setId(itemCatDTO.getCatId());
            newItem.setName(itemCatDTO.getName());
            return categoryRepository.save(newItem);
        }else {
            return null;
        }
    }

    @Override
    public ItemCategory updateCategory(ItemCatDTO itemCatDTO) {
        ItemCategory itemCategory=categoryRepository.findById(itemCatDTO.getCatId()).orElse(null);

        if (itemCategory!=null) {
            itemCategory.setName(itemCatDTO.getName());
            return categoryRepository.save(itemCategory);
        }else {
            return null;
        }
    }

    @Override
    public ItemCategory deleteCategory(Long id) {
        ItemCategory category=categoryRepository.findById(id).orElse(null);
        if(category!=null){
            categoryRepository.delete(category);
            return category;
        }else {
            return null;
        }
    }
}
