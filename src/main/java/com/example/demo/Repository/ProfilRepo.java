package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.DataModel;
import com.example.demo.model.Profil;

@Repository
public interface ProfilRepo extends JpaRepository<Profil,Integer> {

	Optional<Profil> findByName(String name);

	Optional<Profil> findByDataModel(DataModel data);

	Optional<Profil> findByDescription(String description);

}
