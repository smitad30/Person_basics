package com.pocassgn.Person;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

@Component
public class YamlToJson {


public  void convertYamlToJson() {
		
        try {
        	File yamlfile = new File("src/main/resources/propdata.yaml");
            InputStream content = new FileInputStream(yamlfile);
            ObjectMapper yamlReader = new ObjectMapper(new YAMLFactory());
            Object obj = yamlReader.readValue(content, Object.class);
            ObjectMapper jsonWriter = new ObjectMapper();
            String json= jsonWriter.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
            System.out.println(json);
        } catch (IOException ex) {
            ex.printStackTrace();
        } 
        
	
}

}
