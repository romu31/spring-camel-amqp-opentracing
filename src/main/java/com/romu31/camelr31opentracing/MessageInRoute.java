package com.romu31.camelr31opentracing;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.opentracing.ActiveSpanManager;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Profile("consumer")
public class MessageInRoute extends RouteBuilder {
	public void configure() throws Exception {
		from("amqp:queue:testQueue")
				.log("lecture dans le broker")
				.to("log:?level=INFO&showBody=true")
				.process(exchange -> {
					Map<String, Object> s = exchange.getMessage().getHeaders();
					// cause invalid rootspan on qpid jms
					ActiveSpanManager.getSpan(exchange).setOperationName("custom-opname");
				});
				//.to("direct:readQueue");
	}
}
