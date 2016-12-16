package com.wanghaidong.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wanghaidong.beans.SgtPeppers;
import com.wanghaidong.config.CDPlayerConfig;

public class CDPlayerTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(CDPlayerConfig.class);
		SgtPeppers cd = (SgtPeppers) ctx.getBean("sgtPeppers");
		cd.play();

	}

}
