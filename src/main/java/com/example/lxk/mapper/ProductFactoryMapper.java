package com.example.lxk.mapper;

import com.example.lxk.model.ProductFactory;

public interface ProductFactoryMapper {
	int insert(ProductFactory record) throws Exception;

	int deleteById(String id) throws Exception;
}
