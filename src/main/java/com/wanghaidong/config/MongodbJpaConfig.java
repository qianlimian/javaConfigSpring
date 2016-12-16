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
	 * ���ݿ�����
	 */
	@Override
	protected String getDatabaseName() {
		return "OrdersDB";
	}
	/**
	 * ���ݿ��ip�Ͷ˿�
	 */
	@Override
	public Mongo mongo() throws Exception {
		return new MongoClient("172.19.5.228",37017);
	}
	
}
