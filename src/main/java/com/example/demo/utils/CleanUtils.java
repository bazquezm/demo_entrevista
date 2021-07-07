package com.example.demo.utils;

import java.util.List;
import java.util.stream.Collectors;

public class CleanUtils {
	
	public static  List < Integer > removeDuplicates (List < Integer> elements ){
		return elements.stream().distinct().collect(Collectors.toList());
	}

}
