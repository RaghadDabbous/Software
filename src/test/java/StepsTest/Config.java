package StepsTest;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin="html:outputTesting/cuOut.html" ,features = "use_cases",glue = "StepsTest" 
)
public class Config {
	

}
