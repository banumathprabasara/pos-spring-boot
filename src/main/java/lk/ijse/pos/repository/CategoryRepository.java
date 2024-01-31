package lk.ijse.pos.repository;

import lk.ijse.pos.entity.ItemCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<ItemCategory, Long> {

}


