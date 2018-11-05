/**
 * 
 */
package com.nagarro.yourmartapi.util;

import com.nagarro.yourmartapi.entity.ProductDetails;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.core.types.dsl.StringPath;

/**
 * @author ishaanvashishth
 *
 */
public class ProductPredicate {

	private SearchCriteria criteria;

	/**
	 * 
	 */
	public ProductPredicate() {
	}

	/**
	 * @param criteria
	 */
	public ProductPredicate(SearchCriteria criteria) {
		this.criteria = criteria;
	}

	public BooleanExpression getPredicate() {
		PathBuilder<ProductDetails> entityPath = new PathBuilder<>(ProductDetails.class, "productDetails");

		if (isNumeric(criteria.getValue().toString())) {
			NumberPath<Integer> path = entityPath.getNumber(criteria.getKey(), Integer.class);
			int value = Integer.parseInt(criteria.getValue().toString());
			switch (criteria.getOperation()) {
			case ":":
				return path.eq(value);
			case ">":
				return path.goe(value);
			case "<":
				return path.loe(value);
			}
		} else {
			StringPath path = entityPath.getString(criteria.getKey());
			if (criteria.getOperation().equalsIgnoreCase(":")) {
				return path.containsIgnoreCase(criteria.getValue().toString());
			}
		}
		return null;
	}

	public SearchCriteria getCriteria() {
		return criteria;
	}

	public void setCriteria(final SearchCriteria criteria) {
		this.criteria = criteria;
	}

	public static boolean isNumeric(final String str) {
		try {
			Integer.parseInt(str);
		} catch (final NumberFormatException e) {
			return false;
		}
		return true;
	}

}
