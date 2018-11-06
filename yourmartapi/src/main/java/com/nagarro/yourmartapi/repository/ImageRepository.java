/**
 * 
 */
package com.nagarro.yourmartapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.yourmartapi.entity.ImagePaths;

/**
 * @author ishaanvashishth
 *
 */
@Repository
public interface ImageRepository extends JpaRepository<ImagePaths, Integer> {
	
}
