package com.example.LocalMarketplace.repository;

import com.example.LocalMarketplace.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByEmail(String email);

    User findUserByPassword(String password);

    ArrayList<User> findAllByFarmer(Boolean farmer);
}
