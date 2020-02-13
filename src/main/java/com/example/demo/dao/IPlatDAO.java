package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entity.Plat;
@CrossOrigin
@Repository
public interface IPlatDAO extends JpaRepository<Plat, Long> {

}
