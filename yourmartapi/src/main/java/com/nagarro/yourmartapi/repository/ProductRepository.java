/**
 * 
 */
package com.nagarro.yourmartapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;
import org.springframework.stereotype.Repository;

import com.nagarro.yourmartapi.entity.ProductDetails;
import com.nagarro.yourmartapi.entity.QProductDetails;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;

/**
 * @author ishaanvashishth
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<ProductDetails, Integer>, QuerydslPredicateExecutor<ProductDetails>, QuerydslBinderCustomizer<QProductDetails> {
	Page<ProductDetails> findBySellerSellerId(Integer sellerId, Pageable pageable,BooleanExpression predicate);
	Page<ProductDetails> findBySellerSellerId(Integer sellerId, Pageable pageable);
	@Override
    default public void customize(
      QuerydslBindings bindings, QProductDetails root) {
        bindings.bind(String.class)
          .first((SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);
      }
}
