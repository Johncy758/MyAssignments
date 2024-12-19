package runner;

//Applying cucumber options and importing
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//Set the attributes to @cucumberoptions with feature,glue,publish and monochrome
@CucumberOptions(features="src/test/java/feature/SalesForceAcc.feature",glue="steps",publish=true,monochrome=true)

public class CucumberRunner extends AbstractTestNGCucumberTests{

}
