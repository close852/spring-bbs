package com.cjhm.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjhm.board.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
