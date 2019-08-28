package com.example.dosan.repository;

import com.example.dosan.model.SendBean;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SendRepository extends JpaRepository<SendBean, String> {
}