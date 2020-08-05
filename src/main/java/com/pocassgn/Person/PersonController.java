package com.pocassgn.Person;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;





@RestController
@Component
public class PersonController {
	
	@Autowired
	PersonService ps;
	
	@PostMapping("/person")
	public String validateSchema(@RequestBody Map<String,Object> userip) 
	{
		try {
			if(ps.valiadteSchema(userip))
			{
				System.out.println("Valid");
				return "Correct data";
			}
			else
			{
				System.out.println("Invalid");
				return "Incorrect data";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	getBooks();
		return "data";
	}
	
	@SuppressWarnings("unchecked")
	private static void getBooks()
	{
	    final String uri = "http://localhost:8081/Books";
	    RestTemplate restTemplate = new RestTemplate();
	     
	    List<String> result = restTemplate.getForObject(uri, List.class);
	     System.out.println("result from books api");
	    System.out.println(result);
	}
	
	@PostMapping("/person/self")
	
	public ResponseEntity<Object> createBook(@RequestBody Books p)
	{
		
		System.out.println(p);
		
		return new ResponseEntity<>(p,HttpStatus.CREATED);
	} 

@SuppressWarnings("unchecked")
public void convertYamlToJson_validateSchema() throws IOException {
		
	Map<String, Object> map = new HashMap<>();
        try {
        	File yamlfile = new File("src/main/resources/yamlfile.yaml");
            InputStream content = new FileInputStream(yamlfile);
            ObjectMapper yamlReader = new ObjectMapper(new YAMLFactory());
            Object obj = yamlReader.readValue(content, Object.class);
            ObjectMapper jsonWriter = new ObjectMapper();
            String json= jsonWriter.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
            map = jsonWriter.readValue(json, Map.class);
            System.out.println(map);
            System.out.println(json);
        } catch (IOException ex) {
            ex.printStackTrace();
        } 
			if(ps.valiadteSchema(map))
			{
				System.out.println("Valid");
				
			}
			else
			{
				System.out.println("Invalid");
				
			}
	
	
}
}
