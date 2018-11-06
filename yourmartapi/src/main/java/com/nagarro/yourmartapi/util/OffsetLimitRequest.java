package com.nagarro.yourmartapi.util;

import java.io.Serializable;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class OffsetLimitRequest implements Pageable, Serializable {
    private static final long serialVersionUID = -4541509938956089562L;
    private int limit;
    private int offset;
    private Sort sort;
    public OffsetLimitRequest(int offset, int limit, Sort sort){
        this.limit = limit;
        this.offset = offset;
        this.sort = sort;
    }
	@Override
	public int getPageNumber() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getPageSize() {
		// TODO Auto-generated method stub
		return limit;
	}
	@Override
	public long getOffset() {
		// TODO Auto-generated method stub
		return offset;
	}
	@Override
	public Sort getSort() {
		// TODO Auto-generated method stub
		return sort;
	}
	@Override
	public Pageable next() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Pageable previousOrFirst() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Pageable first() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean hasPrevious() {
		// TODO Auto-generated method stub
		return false;
	}
}
