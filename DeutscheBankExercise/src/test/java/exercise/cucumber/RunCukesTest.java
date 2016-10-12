package exercise.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, strict = true,
        tags = {"@test"},
        features = "src/test/resources/features",
        format = {"html:target/cucumber","json:target/cucumber.json"},
        glue = {"exercise.cucumber",
                "exercise.stepdefinitions"})

public class RunCukesTest {

    @BeforeClass
    public static void setup() {
        File file = new File("src/test/resources/output.xml");
        if(file.exists()) {
            file.deleteOnExit();
        }
    }

    @AfterClass
    public static void teardown() {

    }

}
