/**
 * 
 */
package com.nagarro.yourmartapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.yourmartapi.entity.AdminUserDetails;

/**
 * @author ishaanvashishth
 *
 */
@Repository
public interface AdminUserRepository extends JpaRepository<AdminUserDetails, Integer> {
	AdminUserDetails findByYourmartId(String yourmartId);
}
