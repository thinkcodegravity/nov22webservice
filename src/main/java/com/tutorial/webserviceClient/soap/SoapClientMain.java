package com.tutorial.webserviceClient.soap;
import com.tutorial.webserviceClient.soap.stub.MathService;
import com.tutorial.webserviceClient.soap.stub.Math;

public class SoapClientMain {

	/*
	 If webservice program was called Payment
	 	PaymentService ms=new PaymentService();
		Payment m=ms.getPaymentPort();
		
	 */
	public static void main(String[] args) {
		MathService ms=new MathService();
		Math m=ms.getMathPort();
		int result=m.calculateRectangle(10, 20);
		System.out.println("area of rectangle:"+result);
	}
}