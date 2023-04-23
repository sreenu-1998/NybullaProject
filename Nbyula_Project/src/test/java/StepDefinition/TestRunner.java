package StepDefinition;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",glue= {"StepDefinition", "CommonUtils"}, monochrome = true,
plugin = {"pretty","html:target/HTMLReports.html" ,"json:target/cucumber.json"}, tags = "@senario3" )
public class TestRunner {

}
