package com.example.demo;


import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.utils.CleanUtils;
import com.example.demo.utils.HeaderUtils;

@Controller
@RequestMapping("/")
public class HelloController {

	
	/**
	 */
	
	@GetMapping("say")
	public ResponseEntity<String> sayHello ( @RequestHeader Map<String, String> headers,   HttpServletRequest request ){

		System.out.println("Todos los Headers existentes en el request: ");
		Map<String, List<String>> values = HeaderUtils.retrieveHeaders(headers);
		printMap(values);
		
		
		System.out.println("\n\nHeaders filtrados por nombre ");
		List <String> headerNames =  Arrays.asList("cache-control");
		values = HeaderUtils.retrieveHeaderByName(request, headerNames );
		printMap(values);
		

		System.out.println ( "\n\n Remover duplicados" );
		
		List <Integer> elements =  Arrays.asList(1 , 2, 2, 2 , 3,4, 56 );
		System.out.print ( "Arreglo Original: "  );
		printList(elements);
		
		System.out.print ( "\n Arreglo sin duplicados: " );
		printList ( CleanUtils.removeDuplicates(elements));
		
		return ResponseEntity.ok("Hello");
	}
	
	
	private void printMap ( Map<String, List<String>> map ) {
		
		for (Map.Entry<String,  List<String> > entry : map.entrySet()) {
	          System.out.println("Key : " + entry.getKey() + ", Value : " + entry.getValue());
	      }
	}  
	
	private void printList ( List < Integer > elements ) {
		System.out.print(" [ ");
		elements.forEach(num -> System.out.print(num + " " ));
		System.out.print(" ] ");
	}  

}
