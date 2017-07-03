package main.java.spring.boot.xml.controller;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import main.java.spring.boot.xml.model.User;
import main.java.spring.boot.xml.service.AsyncService;

@RestController
@RequestMapping(value = "Rest")
public class RestfulController {
	
	@Autowired
	AsyncService asyncService;

	@RequestMapping(value = "Test", method = RequestMethod.GET, produces = MediaType.ALL_VALUE)
	public Callable<ResponseEntity<?>> test() throws InterruptedException {
		System.out.println("Rest started");
		Callable<ResponseEntity<?>> callable = new Callable<ResponseEntity<?>>() {
			@Override
			public ResponseEntity<?> call() throws Exception {
				System.out.println("async task started");
				Thread.sleep(5000);
				System.out.println("async task finished");
				return ResponseEntity.ok("async result");
			}
		};
		System.out.println("Rest finished");
		return callable;
	}
	

	@RequestMapping(value = "User", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_UTF8_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public ResponseEntity<User> userTest() {
		System.out.println("User api works");
		return ResponseEntity.ok(new User(1, "JJ", "P@ssw0rd"));
	}
	
	@RequestMapping(value="Async", method=RequestMethod.GET, produces=MediaType.ALL_VALUE)
	public ResponseEntity<?> asyncTest() throws InterruptedException, ExecutionException{
		System.out.println("Start: "+Thread.currentThread().getId());
		Future<String> future = asyncService.calculateAsync();
		String ret = future.get();
		System.out.println("End: "+Thread.currentThread().getId());
		return ResponseEntity.ok(ret);
	}

}
