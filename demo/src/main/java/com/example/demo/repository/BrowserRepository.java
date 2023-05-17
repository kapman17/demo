package com.example.demo.repository;

import com.example.demo.domain.Browser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrowserRepository extends JpaRepository<Browser, Integer> {

	Optional<Browser> findTopByIdOrName(Integer id, String name);
}
