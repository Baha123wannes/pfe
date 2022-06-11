package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Integer>{

	Optional<Category> findByName(String p);

}
