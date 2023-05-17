package com.example.demo.repository;

import com.example.demo.domain.Os;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OsRepository extends JpaRepository<Os, Integer> {

	Optional<Os> findTopByIdOrName(Integer id, String name);
}
