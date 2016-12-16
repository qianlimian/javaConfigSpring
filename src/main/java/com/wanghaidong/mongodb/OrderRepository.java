package com.wanghaidong.mongodb;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.wanghaidong.entities.Order;

public interface OrderRepository extends MongoRepository<Order, String>{
	/**
	 * 根据用户名查找订单
	 * @description
	 * @return List<Order>
	 * @author wanghaidong
	 * @date 2016年12月16日 上午11:23:37
	 */
	List<Order> findByCustomer(String customer);
}
