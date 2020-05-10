package com.romu31.camelr31opentracing;


import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class OpenTracingRestController {

	@Autowired
	ProducerTemplate producerTemplate;

	@GetMapping("/one")
	public String test(){
		producerTemplate.sendBody("direct:writeQueue", "<hello>world!</hello>");
		return "ok";
	}


}
