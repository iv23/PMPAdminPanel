/**
 * 
 */
package com.nagarro.yourmartapi.util;

import java.util.ArrayList;
import java.util.List;

import com.querydsl.core.types.dsl.BooleanExpression;

/**
 * @author ishaanvashishth
 *
 */
public class ProductPredicatesBuilder {
	private List<SearchCriteria> params;

	/**
	 * 
	 */
	public ProductPredicatesBuilder() {
        params = new ArrayList<>();
	}
	
	public ProductPredicatesBuilder with(final String key, final String operation, final Object value) {
		params.add(new SearchCriteria(key, operation, value));
        return this;
	}
	
	public BooleanExpression build() {
        if (params.size() == 0) {
            return null;
        }

        final List<BooleanExpression> predicates = new ArrayList<>();
        ProductPredicate predicate;
        for (final SearchCriteria param : params) {
            predicate = new ProductPredicate(param);
            final BooleanExpression exp = predicate.getPredicate();
            if (exp != null) {
                predicates.add(exp);
            }
        }

        BooleanExpression result = predicates.get(0);
        for (int i = 1; i < predicates.size(); i++) {
            result = result.and(predicates.get(i));
        }
        return result;
    }
}
