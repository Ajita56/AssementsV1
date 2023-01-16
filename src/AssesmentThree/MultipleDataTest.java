package AssesmentThree;

import org.testng.annotations.Test;

public class MultipleDataTest {
	@Test(dataProvider = "UserData", dataProviderClass = FiveDataProvider.class)
	public void dataReceiverd(	String favname,
							String fullname,
							String emailb,
							String phonenum,
							String country)
	{
		System.out.println(favname+"\t"+fullname+"\t"+
				emailb+"\t"+phonenum+"\t"+country);
		
	}

}
