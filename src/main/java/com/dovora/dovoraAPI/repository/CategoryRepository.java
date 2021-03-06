package com.dovora.dovoraAPI.repository;

import com.dovora.dovoraAPI.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for Category
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
