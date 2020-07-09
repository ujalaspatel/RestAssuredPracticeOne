package RestAssuredPracticeOne;

import org.testng.annotations.DataProvider;

public class DataForTests {

	@DataProvider(name="DataForPost")
	public Object[][] dataForNewUsers(){
//		Object[][] data=new Object[2][3];
//		data[0][0]="Albert";
//		data[0][1]="Einstein";
//		data[0][2]=2;
//		
//		data[1][0]="Thomas";
//		data[1][1]="Edison";
//		data[1][2]=1;
//		return data;
//		// following is the way you don't have to define indexes like Object[2][3]
		return new Object[][] {
			{"Graham", "bell", 1}, 
			{"Henry", "Ford", 2},
			{"Albert", "Einstein",2}
		};
	}
	
	@DataProvider(name="DataToDelete") 
	public Object[] dataToDeleteUser(){
		return new Object[] {
			4,5,6
		};
	}
}
