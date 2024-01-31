package lk.ijse.pos.repository;

import lk.ijse.pos.entity.Item;
import lk.ijse.pos.entity.ItemCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{
    @Query("SELECT p FROM Item p WHERE p.category = :category")
    List<Item> findProductsByCategory(@Param("category") ItemCategory item);
}
