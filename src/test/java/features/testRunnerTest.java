package features;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions( format = {"pretty", "html:target/cucumber", "json:target/cucumber.json"}
,glue="stepDefinitions", tags={"@addEmpAndCreateAccount"}
)
/**
 * 
 * @author sanjaysai
 *
 */
public class testRunnerTest {
	
}
