/**
 * 
 */
package com.nagarro.yourmartapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.yourmartapi.entity.ProductAttributes;

/**
 * @author ishaanvashishth
 *
 */
@Repository
public interface ProductAttributesRepository extends JpaRepository<ProductAttributes, Integer> {
	
}
