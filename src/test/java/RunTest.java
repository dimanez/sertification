import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "ru.nspk.test.sert.steps",
        features = "src/test/resources/features",
        dryRun = false,
        strict = true,
        snippets = SnippetType.UNDERSCORE
)

public class RunTest {

}
