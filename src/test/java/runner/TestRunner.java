package runner;




import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;


import org.testng.annotations.DataProvider;


@CucumberOptions(
		
		features="src/test/java/features",
		glue={"stepDefination"}
					
		)

		
public class TestRunner extends AbstractTestNGCucumberTests {


	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

	
	/*@AfterClass
	 public static void writeExtentReport() {
	 
	 }*/
}