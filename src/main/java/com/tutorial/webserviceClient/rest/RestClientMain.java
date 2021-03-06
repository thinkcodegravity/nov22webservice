package com.tutorial.webserviceClient.rest;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.tutorial.webserviceClient.rest.Input;
import com.tutorial.webserviceClient.rest.Output;

public class RestClientMain {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter input 1");
		int a=sc.nextInt();
		System.out.println("enter input 2");
		int b=sc.nextInt();
		//testAdd(a,b);
		testJsonRes(a,b);
		/*
		testAdd(); // Consume get rest service with path param
		testSub(); // Consume get rest service with query string input
		testJsonRes(); // Consume get rest service with JSON output
		testMultiplyJsonReq(); // Consume post rest service with JSON input
		*/
	}	
/*	
	Get Http client
	URL = ? includes url and input both
	Response = what output is expected from rest services
		int/string/float etc.. if response is json an object(json compliant)
*/
	// CONSUMING Webservice
	public static void testAdd(int a, int b) {
		RestTemplate getTest=new RestTemplate(); // similar to soap stub program
		int res=getTest.getForObject("http://localhost:8888/addCal/"+a+"/"+b, 
				Integer.class);
		System.out.println("Add rest service result :"+res);
	}
	// get method
	// URL = url include http part + input
	// output = resonse
	public static void testSub(int a, int b) {
		RestTemplate getTest=new RestTemplate();
		int res=getTest.getForObject("http://localhost:8888/subCal?param1="+a+"&param2="+b, Integer.class);
		System.out.println("Sub rest service result :"+res);
	}
/*
	Post Http client
	URL = ? includes url 
	Request = if sending json input pass object(json compliant) 
	Response = what output is expected from rest services
		int/string/float etc.. object(json compliant) if response is json
*/
	public static void testMultiplyJsonReq(int a,int b)
	{
		RestTemplate postTest=new RestTemplate();
		Input input=new Input();
		input.param1=a; 
		input.param2=b; 
		// { "param1":20 , "param2":100 }
		int res=postTest.postForObject("http://localhost:8888/jsonReqMul",
				input,
				Integer.class);
		// Rest template
		// 1) convert input reference into json string. { "param1":20 , "param2":50 }
		// 2) make a call to url.. and pass above json string in the body
		// 3) webservice response is converted into 3 parameter 
		System.out.println("Mul rest service with json input result:"+res);
	}
	public static void testJsonRes(int a, int b)
	{
		RestTemplate restTmp=new RestTemplate();
		Output res=restTmp.getForObject("http://localhost:8888/jsonRes/"+a+"/"+b, Output.class);
		/*
		{
		    "sum": 15,
		    "sub": 5,
		    "mul": 50,
		    "div": 2
		}
		*/
		System.out.println(res.sum);
		System.out.println(res.sub);
		System.out.println(res.mul);
		System.out.println(res.div);
		
		
	}
	/*
	 public static void testSubP() {
		RestTemplate getTest=new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
		map.add("x", "20");
		map.add("y", "10");
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
   
		int res=getTest.postForObject
				("http://localhost:8888/subCalP",request,
						Integer.class);
		System.out.println("Sub rest service result :"+res);
	}
	 */
}
