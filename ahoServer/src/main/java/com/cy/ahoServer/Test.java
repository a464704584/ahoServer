package com.cy.ahoServer;

import java.util.UUID;

public class Test {
	public static void main(String[] args) {
		
		String uuid = UUID.randomUUID().toString();
        //去掉“-”符号
        System.out.println(uuid.replaceAll("-", ""));
		
	}
}
