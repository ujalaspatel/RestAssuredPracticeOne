package RestAssuredPracticeOne;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class GetTestTwo {
	@Test
	public void test_01() {
		given()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.body("data.id[1]", equalTo(8))
			.body("data.first_name", hasItems("Michael","Lindsay"))
			.log().all(); // log all will print the whole response body
		
	}
}
