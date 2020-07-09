package RestAssuredPracticeOne;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class ExamplesRestTestingOnlocalJsonServer {
	//@Test
	public void test_get() {
		baseURI="http://localhost:3000/";	//baseURI is in the restAssured to set the baseURI
		given()
			.get("/users")		//as we have already defined baseURI we can directly give endpoint
		.then()
			.statusCode(200)
			.log().all();
			//.body("data.id[0]", equalTo(7)); // in reqres.in data.id[0] is 7 so we are testing that id match
	}
	//@Test
	public void test_get_parameter() {
		baseURI="http://localhost:3000/";	//baseURI is in the restAssured to set the baseURI
		given()
		.param("name", "Automation") //here we will get the subjects with name Automation	
		.get("/subjects")		//as we have already defined baseURI we can directly give endpoint
		.then()
			.statusCode(200)
			.log().all();
	}
	//@Test
	public void test_post_newUser() {
		baseURI="http://localhost:3000/";	//baseURI is in the restAssured to set the baseURI
		JSONObject postBody=new JSONObject();
		//here we are creating new user
		postBody.put("firstname", "Ashwin");
		postBody.put("lastname", "Trivedi");
		postBody.put("subjectId", 1);
	given()	
		.header("Content-Type", "application/json") //adding header
		.body(postBody.toJSONString())
	.when()
		.post("/users") //as we have already defined baseURI we can directly give endpoint
	.then()
		.statusCode(201)	//if the status code matched means user created successfully
		.log().all();
	}
	//@Test
	public void test_put() {
		baseURI="http://localhost:3000/";	//baseURI is in the restAssured to set the baseURI
		JSONObject postBody=new JSONObject();
		//here we are changing lastname from Trivedi to Aacharya
		postBody.put("firstname", "Ashwin");
		postBody.put("lastname", "Aacharya");
		postBody.put("subjectId", 1);
	given()	
		.header("Content-Type", "application/json") //adding header
		.body(postBody.toJSONString())
	.when()
		.put("/users/4") //as we have already defined baseURI we can directly give endpoint
	.then()
		.statusCode(200)	//if the status code matched means user created successfully
		.log().all();
	}
	//@Test
	public void test_patch() {
		baseURI="http://localhost:3000/";	//baseURI is in the restAssured to set the baseURI
		JSONObject postBody=new JSONObject();
		//here we are changing subjectId from 1 to 2
		//postBody.put("firstname", "Ashwin");
		//postBody.put("lastname", "Aacharya");
		postBody.put("subjectId", 2);
	given()	
		.header("Content-Type", "application/json") //adding header
		.body(postBody.toJSONString())
	.when()
		.patch("/users/4") //as we have already defined baseURI we can directly give endpoint
	.then()
		.statusCode(200)	//if the status code matched means user created successfully
		.log().all();
	}
	@Test
	public void test_delete() {
		baseURI ="http://localhost:3000/";
		when()
		.delete("/users/4")
		.then()
		.statusCode(200)
		.log().all();
	}
}
