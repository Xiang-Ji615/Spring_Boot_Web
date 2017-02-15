package main.java.spring.web.socket.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

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

	@MessageMapping("/chat")
	@SendTo("/topic/messages")
	public OutputMessage send(Message message) throws Exception {
	    String time = new SimpleDateFormat("HH:mm").format(new Date());
	    return new OutputMessage(message.getFrom(), message.getText(), time);
	}
	
	@RequestMapping(value="/")
	public String chat(Model model){
		return "Chat";
	}
}
