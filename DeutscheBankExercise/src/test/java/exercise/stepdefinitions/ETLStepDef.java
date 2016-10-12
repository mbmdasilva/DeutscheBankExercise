package exercise.stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import org.junit.Assert;
import exercise.pages.ETLPage;
import java.io.File;
import java.util.List;

public class ETLStepDef {


    @Given("^the user uploads files$")
        public void the_user_uploads_files(List<String> inputFiles) {
        ETLPage.upload(inputFiles);
    }

    @Given("^the user uploads an invalid file$")
    public void the_user_is_uploads_an_invalid_file(List<String> inputFiles) {
        ETLPage.upload(inputFiles);
    }

    @Then("^the user can see the file \"([^\"]*)\"$")
    public void the_user_can_see_the_file(String xmlFileToLoad) {
        File file = new File("src/test/resources/" + xmlFileToLoad);
        if(!file.exists()) {
            Assert.fail("File does not exist!! Please upload a valid file.");
        }
    }

    @Then("^no output \"([^\"]*)\" file is produced$")
    public void no_output_file_is_produced(String xmlFileToLoad) {
        File file = new File("src/test/resources/" + xmlFileToLoad);
        if(file.exists()) {
            Assert.fail("File has incorrect value(s)!! Please verify.");
        }
    }
}
