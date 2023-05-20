package techproed.runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/*
Runner class; testNG deki .xml file larda belirttiğimiz class'ları,packageları veya methodları nasıl
çalıştırıyorsak, Cucumber frameworkundede Runner class'ındaki tags parametresi ile belirttiğimiz
senaryoyu çalıştırabiliriz
 */

//Cucumber ile JUnit'in entegre olmasını sağlayan test çalıştırıcı notasyonudur.
@RunWith(Cucumber.class)
//Senaryoların nerede ve nasıl çalışacağı, hangi raporu kullanacağıyla alakalı seçenekleri ayarlarız.
@CucumberOptions(plugin = {"pretty", "html:src/test/resources/features/htmlReport/cucumberHooks2.html",
        //"json:src/test/resources/features/htmlReport/cucumber.json",
        "json:target/json-reports/cucumber2.json",
        "junit:src/test/resources/features/htmlReport/cucumber2.xml",
        "rerun:testOutput/failed_scenario.txt" },

        features = "src/test/resources/features",
        glue = {"techproed/stepDefinitions"},
        tags = "@techpro3",
        dryRun = false,
        monochrome = false
)
public class Runner2 {
}
