package com.jems.jms;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class SenderConfig {

	@Value("${artemis.broker-url}")
	  private String brokerUrl;
	  @Value("${artemis.broker-user}")
	  private String brokerUser;
	  @Value("${artemis.broker-password}")
	  private String brokerPassword;

  @Bean
  public ActiveMQConnectionFactory senderActiveMQConnectionFactory() {
	  return new ActiveMQConnectionFactory(brokerUrl, brokerUser, brokerPassword);
  }

  @Bean
  public CachingConnectionFactory cachingConnectionFactory() {
	  CachingConnectionFactory factory =  new CachingConnectionFactory(
        senderActiveMQConnectionFactory());  
	  return factory;
  }

  @Bean
  public JmsTemplate jmsTemplateQueue() {
    return new JmsTemplate(cachingConnectionFactory());
  }
  
  @Bean
  public JmsTemplate jmsTemplateTopic() {
	  JmsTemplate jmsTemplate = new JmsTemplate(cachingConnectionFactory());
	  jmsTemplate.setPubSubDomain(true);	  	  
	  
	return jmsTemplate;		  
  }

  @Bean
  public QueueSender qSender() {
    return new QueueSender();
  }
  
  @Bean
  public TopicSender tSender() {
    return new TopicSender();
  }
}
