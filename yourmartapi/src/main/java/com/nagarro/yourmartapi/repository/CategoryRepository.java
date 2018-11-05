/**
 * 
 */
package com.nagarro.yourmartapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.yourmartapi.entity.CategoryDetails;

/**
 * @author ishaanvashishth
 *
 */
@Repository
public interface CategoryRepository extends JpaRepository<CategoryDetails, Integer> {
	
}
