package runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","html:target/cucumber.html",
        "json:target/cucumber/cucumber-report.json",
        "junit:target/cucumber.xml"},
        features = "src/main/resources/featureFiles/cityBike.feature",
        glue = {"stepDefs"},
        monochrome = true,
        strict = true
)

public class TestRunner {

}
