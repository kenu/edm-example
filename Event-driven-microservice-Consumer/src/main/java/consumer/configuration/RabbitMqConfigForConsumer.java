package consumer.configuration;

import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;

import consumer.component.ConsumeEvents;

@SuppressWarnings("unused")
@Configuration
public class RabbitMqConfigForConsumer implements RabbitListenerConfigurer {

	// Spring application uses the PayloadArgumentResolver to extract, convert, and set the
	// converted message to the method parameter annotated with the @RabbitListener annotation.
	@Bean
	public MappingJackson2MessageConverter mappingJackson2MessageConverter() {
		return new MappingJackson2MessageConverter();
	}

	@Bean
	public DefaultMessageHandlerMethodFactory myHandlerMethodFactory() {
		DefaultMessageHandlerMethodFactory handlerMethodFactory = new DefaultMessageHandlerMethodFactory();
		handlerMethodFactory.setMessageConverter(mappingJackson2MessageConverter());
		return handlerMethodFactory;
	}

	// Overridding this method we can set the custom DefaultMessageHandlerMethodFactory where we set the
	// message converter and the factory will create our PayloadArgumentResolver with the correct convert.
	@Override
	public void configureRabbitListeners(final RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar) {
		rabbitListenerEndpointRegistrar.setMessageHandlerMethodFactory(myHandlerMethodFactory());
	}

	// Set of classes that will be consuming the events.
	// These classes have methods annotated with @RabbitListener annotation.
	@Autowired
	private ConsumeEvents consumeEvents;
}
