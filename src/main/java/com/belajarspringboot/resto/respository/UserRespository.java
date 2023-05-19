package com.belajarspringboot.resto.respository;

import com.belajarspringboot.resto.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRespository extends JpaRepository<User, Integer> {
}
