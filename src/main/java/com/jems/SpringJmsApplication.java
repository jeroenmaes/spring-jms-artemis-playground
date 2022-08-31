package com.jems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jems.jms.QueueSender;

@SpringBootApplication
public class SpringJmsApplication 
implements CommandLineRunner {

 private static Logger LOG = LoggerFactory
    .getLogger(SpringJmsApplication.class);

 @Autowired
 private QueueSender sender;
	
  public static void main(String[] args) {
	LOG.info("STARTING THE APPLICATION");
    SpringApplication.run(SpringJmsApplication.class, args);
    LOG.info("APPLICATION FINISHED");
  }
  
  @Override
  public void run(String... args) {
      LOG.info("EXECUTING : command line runner");
     
      for (int i = 0; i < 10; ++i) {    	  
    	  sender.send("queue1", "MSG " + i);    	  
      }
  }
}
