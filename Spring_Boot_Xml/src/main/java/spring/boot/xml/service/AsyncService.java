package main.java.spring.boot.xml.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncService {
	
	@Async
	public Future<String> calculateAsync() throws InterruptedException {
		CompletableFuture<String> completableFuture = new CompletableFuture<>();

//		Executors.newCachedThreadPool().submit(() -> {
//			Thread.sleep(5000);
//			System.out.println(Thread.currentThread().getId());
//			completableFuture.complete("Hello");
//			return null;
//		});
		
		CompletableFuture<String> future
		  = CompletableFuture.supplyAsync(() -> testMethod1());
		
		return future;
	}
	
	@Async
	public Future<String> calculateAsync2() throws InterruptedException {
		CompletableFuture<String> completableFuture = new CompletableFuture<>();

//		Executors.newCachedThreadPool().submit(() -> {
//			Thread.sleep(5000);
//			System.out.println(Thread.currentThread().getId());
//			completableFuture.complete("Hello");
//			return null;
//		});
		
		CompletableFuture<String> future
		  = CompletableFuture.supplyAsync(() -> testMethod2());
		
		return future;
	}
	
	public String testMethod1(){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getId());
		return "Hello";
	}
	
	public String testMethod2(){
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getId());
		return " World";
	}
	

}

