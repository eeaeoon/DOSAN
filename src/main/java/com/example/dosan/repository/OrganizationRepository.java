package com.example.dosan.repository;

import com.example.dosan.model.OrganizationBean;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<OrganizationBean, String> {

}