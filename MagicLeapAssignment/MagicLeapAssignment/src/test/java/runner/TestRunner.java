//DevelopedBy: Cagatay Ince (cagatayince@gmail.com)
package runner;


import org.junit.runner.RunWith;

import java.io.File;

import org.junit.AfterClass;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import com.cucumber.listener.ExtentCucumberFormatter;
import com.cucumber.listener.Reporter;


@RunWith(Cucumber.class)
@CucumberOptions(
        features ="src/test/java/features"
        ,glue= "seleniumgluecode" ,
        plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"})
public class TestRunner {
	 @AfterClass
	    public static void writeExtentReport() {
	        Reporter.loadXMLConfig(new File("config/report.xml"));
	    
	    }
}