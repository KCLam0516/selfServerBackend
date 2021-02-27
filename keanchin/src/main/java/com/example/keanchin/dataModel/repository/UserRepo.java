package com.example.keanchin.dataModel.repository;

import com.example.keanchin.dataModel.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
    User findByUsername(String username);
    User findById(Long id);
    User findByUsernameAndPassword(String username,String password);
}
