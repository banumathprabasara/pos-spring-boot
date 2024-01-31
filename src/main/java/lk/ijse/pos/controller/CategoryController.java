package lk.ijse.pos.controller;

import lk.ijse.pos.dto.ItemCatDTO;
import lk.ijse.pos.entity.ItemCategory;
import lk.ijse.pos.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public ResponseEntity<List<ItemCategory>> getAllCategory(){
        return ResponseEntity.status(200).body(categoryService.getCategories());
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable Long id){
        try {
            return ResponseEntity.status(200).body(categoryService.getCategoriesById(id));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PostMapping("/categories")
    public ResponseEntity<?> saveCategory(@RequestBody ItemCatDTO catDTO){
        try {
            return ResponseEntity.status(201).body(categoryService.saveCategory(new ItemCatDTO(catDTO.getCatId(),catDTO.getName())));

        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PutMapping("/categories/{id}")
    public ResponseEntity<?> updateCategory(@RequestBody ItemCatDTO catDTO){
        try {
            return ResponseEntity.status(200).body(categoryService.updateCategory(new ItemCatDTO(catDTO.getCatId(),catDTO.getName())));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id){
        try {
            return ResponseEntity.status(200).body(categoryService.deleteCategory(id));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

}
