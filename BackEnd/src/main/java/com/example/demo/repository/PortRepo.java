package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Portfolio;

import ch.qos.logback.core.model.Model;

@Repository
public interface PortRepo extends JpaRepository<Portfolio,Integer> {

}
