package com.chumz.crud_operations.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Books extends JpaRepository<Books, Integer> {
}
