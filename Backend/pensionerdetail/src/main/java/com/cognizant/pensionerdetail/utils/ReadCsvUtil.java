package com.cognizant.pensionerdetail.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class ReadCsvUtil {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReadCsvUtil.class);
	
	public List<String[]> readData() throws IOException { 
	    
	    String file = ".\\src\\main\\resources\\pensioners.csv";
	    List<String[]> content = new ArrayList<>();
	    try(BufferedReader br = new BufferedReader(new FileReader(file))) {
	        String line = "";
	        while ((line = br.readLine()) != null) {
	            content.add(line.split(","));
	        }
	    } catch (FileNotFoundException e) {
	    	LOGGER.debug(e.getMessage());
	    }
	    
	    return content;
	}

}
