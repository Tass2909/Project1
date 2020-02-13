package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Menu;

@Repository
public interface IMenuDAO extends JpaRepository<Menu, Long> {

}
