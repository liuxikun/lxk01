package com.example.lxk.mapper;

import com.example.lxk.model.ProductLevel;

public interface ProductLevelMapper {
	int insert(ProductLevel record) throws Exception;

	int deleteById(String id) throws Exception;

}

