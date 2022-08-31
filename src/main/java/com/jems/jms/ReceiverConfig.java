package com.jems.jms;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

@Configuration
@EnableJms
public class ReceiverConfig {

  @Value("${artemis.broker-url}")
  private String brokerUrl;
  @Value("${artemis.broker-user}")
  private String brokerUser;
  @Value("${artemis.broker-password}")
  private String brokerPassword;

  @Bean
  public ActiveMQConnectionFactory receiverActiveMQConnectionFactory() {
    return new ActiveMQConnectionFactory(brokerUrl, brokerUser, brokerPassword);
  }

  @Bean
  public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
    DefaultJmsListenerContainerFactory factory =
        new DefaultJmsListenerContainerFactory();
    factory
        .setConnectionFactory(receiverActiveMQConnectionFactory());
    factory.setConcurrency("1");
        
    return factory;
  }
  
  @Bean
  public DefaultJmsListenerContainerFactory jmsListenerContainerFactory2() {
	    DefaultJmsListenerContainerFactory factory =
	        new DefaultJmsListenerContainerFactory();
	    factory
	        .setConnectionFactory(receiverActiveMQConnectionFactory());
	    factory.setConcurrency("1");
	    factory.setPubSubDomain(true);
	    factory.setSubscriptionDurable(true);
	    factory.setSubscriptionShared(true);
	    
	    return factory;
	  }

  @Bean
  public QueueReceiver receiver1() {
    return new QueueReceiver();
  }
  
  @Bean
  public TopicReceiver receiver2() {
	    return new TopicReceiver();
	  }
}
