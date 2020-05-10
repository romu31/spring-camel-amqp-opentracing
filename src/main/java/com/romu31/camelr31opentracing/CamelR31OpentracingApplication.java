package com.romu31.camelr31opentracing;

import org.apache.camel.component.amqp.AMQPConnectionDetails;
import org.apache.camel.opentracing.starter.CamelOpenTracing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@CamelOpenTracing
public class CamelR31OpentracingApplication {


	@Bean
	AMQPConnectionDetails amqpConnection() {
		return new AMQPConnectionDetails("amqp://localhost:5672?jms.tracing=opentracing");
	}

	public static void main(String[] args) {
		SpringApplication.run(CamelR31OpentracingApplication.class, args);
	}

}
