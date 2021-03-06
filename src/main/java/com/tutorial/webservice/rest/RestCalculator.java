package com.tutorial.webservice.rest;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.net.HttpHeaders;

import io.swagger.annotations.*;
//PUBLISH Webservice
@RestController
public class RestCalculator {
		 
	// http://localhost:8888/addCal/12/10
	@RequestMapping(value = "/addCal/{param1}/{param2}", method = RequestMethod.GET)
	public int add(@PathVariable(name="param1") int num1,
			@PathVariable(name="param2") int num2) {
		int	sum=num1 + num2;
		return sum;
	}
	
	
	// http://localhost:8888/subCal?param1=10&param2=5
	@RequestMapping(value = "/subCal", method = RequestMethod.GET)
	public int sub(@RequestParam("param1") int a,@RequestParam("param2")  int b) {
		int sub=a - b;
		return sub;
	}
	
	// http://localhost:8888/jsonReqMul - send json in request body,
	// input type json string
	// JSON string input >>>>> converted >>>> Java Input Object
	@RequestMapping(value = "/jsonReqMul", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public int mulCalculator(@RequestBody Input in) {
		// "Input" parameter is json compliant java program
		int mul=in.param1 * in.param2;
		return mul;
	}
	
	// http://localhost:8888/jsonRes/1/2
	// java object Output >>>>> converted >>>> JSON string
	@RequestMapping(value = "/jsonRes/{param1}/{param2}", 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Output calculator(@PathVariable int param1, @PathVariable int param2) {
		Output res = new Output();
		res.setSum(param1 + param2);
		res.setSub(param1 - param2);
		res.setMul(param1 * param2);
		res.setDiv(param1 / param2);
		return res;
	}
}