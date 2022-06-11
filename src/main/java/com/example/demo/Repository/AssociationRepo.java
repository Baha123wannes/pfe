package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Association;

@Repository
public interface AssociationRepo extends JpaRepository<Association,Integer>{

	Optional<Association> findByAssociation(String name);

}
