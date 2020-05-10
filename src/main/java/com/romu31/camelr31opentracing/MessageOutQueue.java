package com.romu31.camelr31opentracing;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("producer")
public class MessageOutQueue extends RouteBuilder {
	public void configure() throws Exception {
		from("direct:writeQueue")
				.to("log:?level=INFO&showBody=true")
				.log("ecriture dans le broker")
				.to("amqp:queue:testQueue");
	}
}
