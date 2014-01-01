package outh;


import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.simple.parser.ContainerFactory;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

	public class JsonParser {
	
	   public Map<String, String> jsonParser(String line) throws ParseException 
	   {
		
		   String jsonText =line;
		   JSONParser parser = new JSONParser();
		   ContainerFactory containerFactory = new ContainerFactory(){
		     public List<String> creatArrayContainer() {
		       return new LinkedList<String>();
		     }

		     public Map<String, String> createObjectContainer() {
		       return new LinkedHashMap<String, String>();
		     }
		                         
		   };
		                 
		   
		     @SuppressWarnings("unchecked")
			Map<String, String> json = (Map<String, String>)parser.parse(jsonText, containerFactory);
		     return json;
		   
		 
		  
	   }
	}


