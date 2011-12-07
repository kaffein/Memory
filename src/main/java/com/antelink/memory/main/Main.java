package com.antelink.memory.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.antelink.memory.inputInterpreter.MemoryClient;


public class Main {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ApplicationContext context = new FileSystemXmlApplicationContext("classpath:META-INF/applicationContext.xml");
		MemoryClient memoryClient = (MemoryClient) context.getBean("memoryClient");
		memoryClient.interpret(args);
	}

}
