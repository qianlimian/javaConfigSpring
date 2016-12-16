package com.wanghaidong.test;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wanghaidong.config.MongodbJpaConfig;
import com.wanghaidong.entities.Item;
import com.wanghaidong.entities.Order;
import com.wanghaidong.mongodb.OrderRepository;

public class MongodbTest {
	public static void main(String[] args){
		ApplicationContext ctx = new AnnotationConfigApplicationContext(MongodbJpaConfig.class);
		OrderRepository orderRepository = (OrderRepository) ctx.getBean("orderRepository");
		/*Item item = new Item();
		item.setId(1L);
		item.setPrice(51.8);
		item.setProduct("FilmTicket");
		item.setQuantity(1);
		Order order = new Order();
		order.setCustomer("wanghaidong");
		order.setId("1");
		order.setType("excellent");
		Collection<Item> items = new LinkedHashSet<Item>();
		items.add(item);
		order.setItems(items);
		System.out.println("begin insert...");
		orderRepository.save(order);
		System.out.println("end insert...");*/
		List<Order> list = orderRepository.findByCustomer("wanghaidong");
		for(Order order : list){
			System.out.println(order.getType());
		}
			
		
	}
	
}
