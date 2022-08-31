package com.jems.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;

public class TopicReceiver {

  private static final Logger LOGGER =
      LoggerFactory.getLogger(TopicReceiver.class);

  //auto-generated shared durable subscription
  @JmsListener(destination = "topic1", containerFactory = "jmsListenerContainerFactory2", subscription = "sub1")
  public void receive1a(String message) {
    LOGGER.info("receiver 1a message='{}'", message);
    
    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
    }
  }
  
  //2nd listener on the same sub -> "shared"
  @JmsListener(destination = "topic1", containerFactory = "jmsListenerContainerFactory2", subscription = "sub1")
  public void receive1b(String message) {
    LOGGER.info("receiver 1b message='{}'", message);
    
    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
    }
  }
  
  //pre-generated multicast queue with fqdn naming convention
  @JmsListener(destination = "topic1::sub2")
  public void receive2(String message) {
    LOGGER.info("receiver 2 message='{}'", message);
    
    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
    }
  }
}
