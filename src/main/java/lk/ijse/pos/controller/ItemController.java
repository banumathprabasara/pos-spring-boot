package lk.ijse.pos.controller;

import lk.ijse.pos.dto.ItemDTO;
import lk.ijse.pos.entity.Item;
import lk.ijse.pos.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ItemController {
    @Autowired
    private ItemService itemService;
    @GetMapping("/items")
    public ResponseEntity<List<Item>> getAllItems() {
        return ResponseEntity.status(200).body(itemService.getAllItems());
    }

    @PostMapping("/items")
    public ResponseEntity<?> createItems(@RequestBody ItemDTO itemDTO) {
        try {
            return ResponseEntity.status(201).body(itemService.saveItem(itemDTO));
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Failed to create the item");
        }
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<?> getItemsById(@PathVariable Long id) {
        Item item = itemService.getItemById(id);

        if(item != null) {
            return ResponseEntity.status(200).body(item);
        } else {
            return ResponseEntity.status(404).body("Item not found");
        }
    }

    @PutMapping("/items/{id}")
    public Item updateItems(@RequestBody ItemDTO itemDTO) {
        return itemService.updateItem(itemDTO);
    }

    @GetMapping("/category/{id}/items")
    public ResponseEntity<List<Item>> getItemsByCategory(@PathVariable Long id) {
        return ResponseEntity.ok().body(itemService.getItemByCategory(id));
    }

    @DeleteMapping("/items/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id){
        try {
            return ResponseEntity.status(200).body(itemService.deleteItem(id));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}
