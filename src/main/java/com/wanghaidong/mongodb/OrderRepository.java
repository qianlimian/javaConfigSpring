package com.wanghaidong.mongodb;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.wanghaidong.entities.Order;

public interface OrderRepository extends MongoRepository<Order, String>{
	/**
	 * �����û������Ҷ���
	 * @description
	 * @return List<Order>
	 * @author wanghaidong
	 * @date 2016��12��16�� ����11:23:37
	 */
	List<Order> findByCustomer(String customer);
}
