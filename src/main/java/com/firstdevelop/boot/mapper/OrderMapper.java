package com.firstdevelop.boot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderMapper {
	public void insert(@Param("productID")int productID,@Param("quantity")int quantity,@Param("userID") long id); 
}
