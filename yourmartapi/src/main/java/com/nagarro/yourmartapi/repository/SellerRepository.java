/**
 * 
 */
package com.nagarro.yourmartapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.yourmartapi.entity.SellerDetails;

/**
 * @author ishaanvashishth
 *
 */
@Repository
public interface SellerRepository extends JpaRepository<SellerDetails, Integer> {
	
}
