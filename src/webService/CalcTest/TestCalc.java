package webService.CalcTest;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;
import org.skyscreamer.jsonassert.JSONAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


import com.ExcelPackage.ReadJsonFile;
import com.jayway.restassured.response.Response;
public class TestCalc{
	
	
String BaseURL="http://localhost:1000/calcrest/calc/";


@Test
	public void testAdd() throws Exception{

	int a=Integer.parseInt(ExcelUtils.getCellData(1, 1));
int b=Integer.parseInt(ExcelUtils.getCellData(1, 2));


	String URL=BaseURL+"add/"+a+"/"+b+"/";
		Response addResponse=RestUtil.get(URL);
//		addResponse.prettyPrint();
		System.out.println(addResponse.print());
	
	
	String jsonString=ReadJsonFile.readJsonFile(ExcelUtils.Path_TestData+"\\JSONOutputFile\\sum.json").toString();
	
	Assert.assertEquals(jsonString, addResponse.asString());
	
	boolean result=addResponse.asString().equals(jsonString);
	if(result){
		ExcelUtils.setCellData("Pass", 1, 3);
	}
	else{
		ExcelUtils.setCellData("Fail", 1, 3);
	}
	
		
		
		
	}


@Test
	public void testSub() throws Exception{

	int a=Integer.parseInt(ExcelUtils.getCellData(2, 1));
int b=Integer.parseInt(ExcelUtils.getCellData(2, 2));


	String URL=BaseURL+"sub/"+a+"/"+b+"/";
		Response addResponse=RestUtil.get(URL);
//		addResponse.prettyPrint();
		System.out.println(addResponse.asString());
	
	
	String jsonString=ReadJsonFile.readJsonFile(ExcelUtils.Path_TestData+"\\JSONOutputFile\\sub.json");
	
	System.out.println("String from file:"+jsonString);
	Assert.assertEquals(jsonString, addResponse.asString());
	
	boolean result=addResponse.asString().equals(jsonString);
	if(result){
		ExcelUtils.setCellData("Pass", 2, 3);
	}
	else{
		ExcelUtils.setCellData("Fail", 2, 3);
	}
	
		
		
		
	}


}
