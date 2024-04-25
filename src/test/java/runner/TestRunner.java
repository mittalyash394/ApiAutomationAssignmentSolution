package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/feature"}, // for passing the feature file path
        glue = {"stepdef"}, // for giving the stepDef folder name
        tags = "not @ignore and not @skip", // Skips scenarios and steps with @ignore or @skip tags
//        plugin = {"json:target/cucumber-report.json", "pretty", "html:target/test-report.html"}, // plugin to make the report
        publish = true, // all records will be printed on terminal
        monochrome = true // only recognizable texts should be printed on terminal
)
public class TestRunner {
}
