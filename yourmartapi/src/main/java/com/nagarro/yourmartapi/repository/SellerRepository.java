/**
 * 
 */
package com.nagarro.yourmartapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;
import org.springframework.stereotype.Repository;

import com.nagarro.yourmartapi.entity.QSellerDetails;
import com.nagarro.yourmartapi.entity.SellerDetails;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;

/**
 * @author ishaanvashishth
 *
 */
@Repository
public interface SellerRepository extends JpaRepository<SellerDetails, Integer>, QuerydslPredicateExecutor<SellerDetails>, QuerydslBinderCustomizer<QSellerDetails>  {
	@Override
    default public void customize(
      QuerydslBindings bindings, QSellerDetails root) {
        bindings.bind(String.class)
          .first((SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);
      }
}
