package main.java.spring.boot.xml.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncService {

	@Async
	public Future<String> calculateAsync() throws InterruptedException {
		CompletableFuture<String> completableFuture = new CompletableFuture<>();

		Executors.newCachedThreadPool().submit(() -> {
			Thread.sleep(5000);
			System.out.println(Thread.currentThread().getId());
			completableFuture.complete("Hello");
			return null;
		});

		return completableFuture;
	}
}
