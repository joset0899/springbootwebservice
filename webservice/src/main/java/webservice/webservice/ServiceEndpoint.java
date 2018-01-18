package webservice.webservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import webservice.bean.Greeting;
import webservice.bean.ObjectFactory;
import webservice.bean.Person;

@Endpoint
public class ServiceEndpoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceEndpoint.class);

	  @PayloadRoot(namespace = "http://codenotfound.com/types/helloworld", localPart = "person")
	  @ResponsePayload
	  public Greeting sayHello(@RequestPayload Person request) {
	    LOGGER.info("Endpoint received person[firstName={},lastName={}]", request.getFirstName(),
	        request.getLastName());

	    String greeting = "Hello " + request.getFirstName() + " " + request.getLastName() + "!";

	    ObjectFactory factory = new ObjectFactory();
	    Greeting response = factory.createGreeting();
	    response.setGreeting(greeting);

	    LOGGER.info("Endpoint sending greeting='{}'", response.getGreeting());
	    return response;
	  }
}
