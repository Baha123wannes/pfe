package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.DlmsOperation;


@Repository
public interface OperationRepo extends JpaRepository<DlmsOperation,Integer> {

}
