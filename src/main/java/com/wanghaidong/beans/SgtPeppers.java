package com.wanghaidong.beans;

import org.springframework.stereotype.Component;

import com.wanghaidong.interfaces.CompactDisc;

@Component
public class SgtPeppers implements CompactDisc{
	private String title = "Wanghaidong's first Sgt music";
	private String author = "The beatles";
	public void play() {
		System.out.println("title: "+title+ " author: "+author);
		
	}

}
