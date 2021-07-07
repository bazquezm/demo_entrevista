package com.example.demo.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;

public class HeaderUtils {
	
	/**
	 *  Obtiene todos los headers del request
	 *  
	 *  
	 *  @return Mapa donde la llave es el nombre del Header y el valor es una lista ya que se puede 
	 *  		recibir mas de un valor en un header
	 * 
	 * */
	public static Map<String, List<String>> retrieveHeaders ( Map<String, String> headers ){
		
		Map<String, List<String>> values = new HashMap<String, List<String>> ();
		
		headers.forEach((key, value) -> {
			values.put(key, Stream.of( value.split(",")).collect( Collectors.toList() ));
	    });
		
		return values;
	}
	
	/**
	 *  Obtiene todos los headers filtrados por nombre
	 *  
	 *  
	 *  
	 *  @return Mapa donde la llave es el nombre del Header y el valor es una lista ya que se puede 
	 *  		recibir mas de un valor en un header
	 * 
	 * */
	public static Map<String, List<String>> retrieveHeaderByName ( HttpServletRequest request, List<String> headerNames ){
		
		Map<String, List<String>> values = new HashMap<String, List<String>> ();
		
		headerNames.parallelStream().forEach( headerName -> {
				String headerFromRequest = (String) request.getHeader(headerName );
				values.put(headerName, Stream.of( headerFromRequest.split(",") ).collect( Collectors.toList() ));
		});
		
		return values;
	}
	
}
