package com.example.lxk.mapper;


import com.example.lxk.model.ProductType;

public interface ProductTypeMapper {
	int insert(ProductType record) throws Exception;

	int deleteById(String id) throws Exception;

}
