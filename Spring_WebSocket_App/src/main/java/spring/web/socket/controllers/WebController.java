package main.java.spring.web.socket.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import main.java.spring.web.socket.models.Message;
import main.java.spring.web.socket.models.OutputMessage;

@Controller
@RequestMapping(value="Web")
public class WebController {

	@MessageMapping("/chat/{value}")
	@SendTo("/topic/messages/{value}")
	public OutputMessage send(Message message, @DestinationVariable String value) throws Exception {
		System.out.println(value);

	    String time = new SimpleDateFormat("HH:mm").format(new Date());
	    return new OutputMessage(message.getFrom(), message.getText(), time);
	}
	
	@RequestMapping(value="Chat")
	public String chat(Model model){
		return "Chat";
	}
}
