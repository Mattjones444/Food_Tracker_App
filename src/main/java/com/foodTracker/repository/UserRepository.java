package com.foodTracker.repository;
import com.foodTracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    
}
