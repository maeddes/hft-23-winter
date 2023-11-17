package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StringRepository extends JpaRepository<StringEntity, String> {

}