package com.foodTracker.repository;
import com.foodTracker.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ItemRepository extends JpaRepository<Item, Long> {
    
}
