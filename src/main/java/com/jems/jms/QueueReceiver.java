package com.jems.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;

public class QueueReceiver {

  private static final Logger LOGGER =
      LoggerFactory.getLogger(QueueReceiver.class);

  @JmsListener(destination = "queue1")
  public void receive(String message) {
    LOGGER.info("received message='{}'", message);
    
    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
    }
  }
}
