package com.jems.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

public class QueueSender {

  private static final Logger LOGGER =
      LoggerFactory.getLogger(QueueSender.class);

  @Autowired
  private JmsTemplate jmsTemplateQueue;
  
  
  public void send(String destinationQueue, String message) {
	    LOGGER.info("sending message to queue='{}'", message);
	    
	    jmsTemplateQueue.convertAndSend(destinationQueue, message);
	  }
}
