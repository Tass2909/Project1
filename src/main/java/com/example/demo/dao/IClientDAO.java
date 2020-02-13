package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entity.Client;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface IClientDAO extends JpaRepository<Client, Long> {
//	@Query("select nom_client from client where nom_client like %?1")
//	List<Client> findByNameEndsWith(String chars);
}
