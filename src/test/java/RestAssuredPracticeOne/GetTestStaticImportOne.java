package RestAssuredPracticeOne;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class GetTestStaticImportOne {
	Assert softAssert;
	@Test
	void test_01() {
		// when you use the static import no need to create new class object as in GetTestOne class we did
		Response response=get("https://reqres.in/api/users?page=2");   
		System.out.println(response.asString());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getTime());
		
		int statusCode=response.getStatusCode();
		Assert.assertEquals(statusCode, 200); // we are testing that status code is 200 or not, 
											//if it is 200 then test will pass.
	}
	@Test
	void test_02() {
		given()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.body("data.id[0]", equalTo(7)); // in reqres.in data.id[0] is 7 so we are testing that id match
	}
}

