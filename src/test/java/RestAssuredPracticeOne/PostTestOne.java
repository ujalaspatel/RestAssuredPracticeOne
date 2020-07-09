package RestAssuredPracticeOne;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PostTestOne {

	@Test
	public void test_post_01() {
		//with post request we need to pass data body //here we are trying to create key-value pair for passing the body to the post request
		// there are multiple way we can pass the key-value pair //here we are using Map and HashMap of jav.util class
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "Ujala");  //here we want name in double quote then so \" is used to print the " quote.
		map.put("job", "qa");
		System.out.println(map);
		//but to pass body in proper json format we will add the json dependencies to pom 
		// some of the dependencies options for json is gson, jackson, json.simple, json.
		//add json.simple dependencies in pom 
		JSONObject postBody= new JSONObject(map);
		System.out.println(postBody);			// both the style gives gives the same output
		System.out.println(postBody.toJSONString()); // postBody or postBody.toJASONString()
		//if you don't want to use the map you can directly use 
			//postBody.put("name", "Ujala");
			//postBody.put("job","qa");
			//System.out.println(postBody);			
			//System.out.println(postBody.toJSONString());  
		given()
			.header("Content-Type", "application/json") //adding header
			.body(postBody.toJSONString())
		.when()
			.post("https://reqres.in/api/users")
		.then()
			.statusCode(201)	//if the status code matched means user created successfully
			.log().all();
	}
	@Test
	public void test_put_02() {
		//here these test is for update user
		JSONObject postBody= new JSONObject();
		postBody.put("name", "Patel");
		postBody.put("job","Tester");
		
		given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(postBody.toJSONString())
	.when()
		.put("https://reqres.in/api/users/2")
	.then()
		.statusCode(200)	//if the status code matched means user updateded successfully
		.log().all();	//log().all() will display the whole response body in the console
	}
	@Test
	public void test_patch_03() {
		//here these test is for patch user, here also we will update the user
		JSONObject postBody= new JSONObject();
		postBody.put("name", "Patel");
		postBody.put("job","Tester");
		
		given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(postBody.toJSONString())
	.when()
		.put("https://reqres.in/api/users/2")
	.then()
		.statusCode(200)	//if the status code matched means user updateded successfully
		.log().all();	//log().all() will display the whole response body in the console
	}
	//@Test
	public void test_delete_04() {
		//here these test is for patch user, here also we will update the user
	when()
		.delete("https://reqres.in/api/users/2")
	.then()
		.statusCode(204)	//if the status code matched means user deleted successfully
		.log().all();	//log().all() will display the whole response body in the console
	}
}
