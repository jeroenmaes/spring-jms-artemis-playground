package com.jems.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

public class TopicSender {

  private static final Logger LOGGER =
      LoggerFactory.getLogger(TopicSender.class);

  @Autowired
  private JmsTemplate jmsTemplateTopic;
 
  public void send(String destinationQueue, String message) {
	    LOGGER.info("sending message to topic='{}'", message);
	    	    
	    jmsTemplateTopic.convertAndSend(destinationQueue, message);
	  }
}
