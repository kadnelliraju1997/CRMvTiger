package practiceDataDrivenTesting;

import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class CommonDataFromJson {
	public static void main(String[] args) throws Exception, IOException, ParseException {
		//step1 : parse Json Physical file into java Object using JSONParse class
		JSONParser parser=new JSONParser();
		Object obj = parser.parse(new FileReader("C:\\Users\\Admin\\OneDrive\\Desktop\\TEK PYRAMID\\CommonData.json"));
		
		//step2: Convert java Object in to JsonObject using down casting
		JSONObject map=(JSONObject)obj;
		
		//Step3: get the value from json file using key
		System.out.println(map.get("browser"));System.out.println(map.get("url"));
		System.out.println(map.get("username"));System.out.println(map.get("password"));
		
	}

}
