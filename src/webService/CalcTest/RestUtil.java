package webService.CalcTest;

import java.util.Map;




import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;



public class RestUtil {
	
	public static void setup(){
		RestAssured.baseURI="http://localhost:1000/";
		RestAssured.basePath="calcrest/calc/";
	}
	
public static Response get(String path) {
		
		Response response = RestAssured
				.given()
				.log()
				.all()
				//.queryParams(params)
				
				.header("Accept","application/json")
				.get(path);
		return response;

}
}
