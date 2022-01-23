package com.cognizant.pensionerdetail.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;

import com.cognizant.pensionerdetail.utils.ReadCsvUtil;

public class ReadCsvutilTest {
	
	@Mock
	ReadCsvUtil readCsvUtil;
	
	List<String[]> content = new ArrayList<>();
	
	@BeforeEach
	public void setup() throws Exception{
			content = readCsvUtil.readData();
	}
	
	@Test
	public void utilTest() throws Exception{
		
		String file = ".\\src\\main\\resources\\pensioners.csv";
	    List<String[]> temp = new ArrayList<>();
	    try(BufferedReader br = new BufferedReader(new FileReader(file))) {
	        String line = "";
	        while ((line = br.readLine()) != null) {
	            content.add(line.split(","));
	        }
	    } catch (FileNotFoundException e) {
	       e.printStackTrace();
	    }
	    
	    for(int i=0;i<temp.size();++i) {
	    	
	    	assertEquals(temp.get(i), content.get(i));
	    	
	    }
	    
	}

}
