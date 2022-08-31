package com.jems.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/send")
public class SendController {

	 @Autowired
	 private QueueSender qSender;

	 @Autowired
	 private TopicSender tSender;
	 
  @GetMapping
  public String send(@RequestParam String m, @RequestParam String q, @RequestParam String t) {
	  
	  if(t.equals("q")) //send message to queue
		  qSender.send(q, m);
	  else if(t.equals("t")) //send message to topic
		  tSender.send(q, m);
	  
    return "Rest Message sent: " +m;
  }
}