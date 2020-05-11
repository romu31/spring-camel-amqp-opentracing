package com.romu31.camelr31opentracing;


import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/test")
@Slf4j
public class OpenTracingRestController {

	@Autowired
	ProducerTemplate producerTemplate;

	@GetMapping("/one")
	public String test(@RequestHeader Map<String, String> headers){
		headers.forEach((key, value) -> {
			log.info(String.format("Header '%s' = %s", key, value));
		});
		producerTemplate.sendBody("direct:writeQueue", "<hello>world!</hello>");
		return "ok";
	}


}
