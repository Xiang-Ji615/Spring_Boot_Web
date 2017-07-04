package main.java.spring.boot.xml.controller;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import main.java.spring.boot.xml.meta.JJResource;
import main.java.spring.boot.xml.model.User;
import main.java.spring.boot.xml.service.AsyncService;

@CrossOrigin
@RestController
@RequestMapping(value = "Rest")
public class RestfulController {
	
	@Autowired
	@Lazy
	AsyncService asyncService;
	
	@Value(value="${jj.test.value}")
	String jjValue;

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
	public ResponseEntity<?> asyncTest(HttpServletRequest request) throws InterruptedException, ExecutionException{
		HttpSession session = request.getSession();
		System.out.println("Start: "+Thread.currentThread().getId());
		Future<String> future = asyncService.calculateAsync();
		Future<String> future2 = asyncService.calculateAsync2();
		String ret = "";
		while(true){
			if(future.isDone() && future2.isDone()){
				ret = future.get() + future2.get();
				break;
			}
			System.out.println(new Date());
			Thread.sleep(1000);

		}
		System.out.println("End: "+Thread.currentThread().getId());
		return ResponseEntity.ok(ret);
	}
	
	
	@RequestMapping(value="JJTest", method=RequestMethod.GET, produces=MediaType.ALL_VALUE)
	public ResponseEntity<?> jjProfileTest(){
		return ResponseEntity.ok(jjValue);
	}
	

}
