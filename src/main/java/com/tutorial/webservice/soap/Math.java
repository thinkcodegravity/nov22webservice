package com.tutorial.webservice.soap;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;

// publishing/providing webservice
// clients can calcualte area of square and rectangle
@WebService
@SOAPBinding(style = Style.DOCUMENT, 
parameterStyle = ParameterStyle.WRAPPED)
/*
 style rpc = return type and input are primitve or string
 style document = return type OR input are complex
 style document, parmStyle literal = 
 	if you have overloaded methods
 style document, parmStyle wrapped= 
 	if you have 2 methods with same input signature
 */
public class Math {
		public int calculateSquare(int sides) {
			return sides * sides;
		}
		public int calculateRectangle(int height,int width) {
			return height * width;
		}
}
