package com.example.dosan.repository;

import com.example.dosan.model.ManageBean;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManageRepository extends JpaRepository<ManageBean, String> {

}