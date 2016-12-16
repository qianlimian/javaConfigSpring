package com.wanghaidong.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;


@Configuration
@EnableMongoRepositories(basePackages="com.wanghaidong.mongodb")
public class MongodbJpaConfig extends AbstractMongoConfiguration{

	/**
	 * 数据库名称
	 */
	@Override
	protected String getDatabaseName() {
		return "OrdersDB";
	}
	/**
	 * 数据库的ip和端口
	 */
	@Override
	public Mongo mongo() throws Exception {
		return new MongoClient("172.19.5.228",37017);
	}
	
}
