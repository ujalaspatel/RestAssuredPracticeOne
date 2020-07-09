package RestAssuredPracticeOne;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.when;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterExampleOne {
	@Parameters({"userId"})
	@Test
	public void test_delete(int userId) {
		baseURI ="http://localhost:3000/";
		when()
		.delete("/users/"+ userId);
		
	}
}
