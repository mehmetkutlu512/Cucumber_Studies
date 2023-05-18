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
@CucumberOptions(plugin = {"pretty", "html:src/test/resources/features/htmlReport/cucumbertc3.html",
                                     "json:src/test/resources/features/htmlReport/cucumber.json",
                                     "junit:src/test/resources/features/htmlReport/cucumber.xml"},

                // plugin parametresi ile pretty ifadesi kullanılırsa konsolda scenario'lar ile bilgi gösterir.
                 features = "src/test/resources/features/ day30_IlkFeature",
                 glue = {"techproed/stepDefinitions"}, // Bu parametre ile kodlarımızı yazdığımız stepDefinition
                                                      // class'nın package'ını belirtiriz.
                 tags = "@gr1",
                 dryRun = false, // dryRun = false Test adımlarını kontrol eder ve browser'ı çalıştırır.
                                // dryRun = true Test adımlarını sadece kontrol eder
                                // default olarak false'dır.
                 monochrome = false // pretty ifadesinden sonra monochrome = true kullanırsak senaryo adımlarını tek renk olarak siyah gösterir.
                                   // monochrome = false kullanırsak renkli gösterir.
)

/*
features ===> features'ların olduğu packega'ın yolunu ver(ContentRoot)
glue ====> stepDefinition'ların olduğu packega'ın yolunu ver(Source Root)
tags ====> çalıştırmak istediğin grubu yaz
 */
public class Runner {
}
