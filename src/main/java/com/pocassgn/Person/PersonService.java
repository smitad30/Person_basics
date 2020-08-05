package com.pocassgn.Person;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;




@Service
public class PersonService {
	
	public boolean checkRequired(Map<String,Object> jsonInput)
    {
    	try {
    	List<String> jsonList = new ArrayList<String>(jsonInput.keySet());	
    	List<String> jsonSchemaList = readJsonWithObjectMapper();
    	boolean result = jsonList.containsAll(jsonSchemaList);    	//to check if required fields are present in json input
    	System.out.println(result);
    	return result;
    	}
    	catch(Exception e){
    		System.out.println(e);
    		return false;
    	}
    }
    

	//To convert jsonsSchema to Map
		
	   @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<String> readJsonWithObjectMapper() throws IOException {	
        ObjectMapper objectMapper = new ObjectMapper();
        File initialFile = new File("src/main/resources/jsonschema.json");
        InputStream jsonschema = new FileInputStream(initialFile);
        Map<String,Object> schemaMap = objectMapper.readValue(jsonschema,Map.class);
        System.out.println(schemaMap);
        List<String> schemaKeyList=	(ArrayList) schemaMap.get("required");
	    return schemaKeyList ;
	      
   	}

@SuppressWarnings("unchecked")
public boolean valiadteSchema(Map<String, Object> inputMap) throws IOException {   //Validate the Json Input
	Map<String, Object> requiredMap = new HashMap<String, Object>();
	List<Map<String, Object>> schemaRequiredList = new ArrayList<>();
	if (checkRequired(inputMap)) {
		System.out.println("all elements present");
	} else {
		System.out.println("elements absent");
		return false;
	}
	
	ObjectMapper objectMapper = new ObjectMapper();    
	File initialFile = new File("src/main/resources/jsonschema.json");
	InputStream jsonschema = new FileInputStream(initialFile);
	Map<String, Object> schemaMap = objectMapper.readValue(jsonschema, Map.class);
	boolean properties = schemaMap.containsKey("properties"); //get into properties,
	if (properties) {
		Map<String, Object> propertiesMap = (Map<String, Object>) schemaMap.get("properties");//gets everything inside properties.
		requiredMap = propertiesMap;									
		ArrayList<String> property_keys = new ArrayList<>(propertiesMap.keySet());
		System.out.println(property_keys);
		
		for (int i = 0; i < propertiesMap.size(); i++) {
			if (requiredMap.containsKey(property_keys.get(i))) {
				schemaRequiredList.add((Map<String, Object>) requiredMap.get(property_keys.get(i)));///it will add map of particular property, like name,age ,etc.
				System.out.println(schemaRequiredList);
				Map<String, String> finalMap = new HashMap<>();
				finalMap = (Map<String, String>) requiredMap.get(property_keys.get(i));//get name of property like name,age.
                System.out.println(finalMap);
				
				if (finalMap.get("type").equalsIgnoreCase("String")) {
					if (inputMap.get(property_keys.get(i)) instanceof String) {///gets json input details
						System.out.println(property_keys.get(i) + "Successful");
					} else {
						return false;
					}
				}

				if (finalMap.get("type").equalsIgnoreCase("Integer")) {
					if (inputMap.get(property_keys.get(i)) instanceof Integer) {
						System.out.println(property_keys.get(i) + "Successful");
					} else {
						return false;
					}
				}

			}
		}

	}
	return true;
}}

