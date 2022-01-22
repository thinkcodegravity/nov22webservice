package com.tutorial.webservice.soap;
import javax.xml.ws.Endpoint;
public class SoapWebServiceMain {

	public static void main(String[] args) {
		Math mysoapWeb=new Math();
		Endpoint.publish("http://localhost:6060/math", mysoapWeb);
	}

}
