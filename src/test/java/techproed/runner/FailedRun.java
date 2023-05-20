package techproed.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty",
        "html:src/test/resources/features/htmlReport/cucumberHooks.html",
        "json:src/test/resources/features/htmlReport/cucumber.json",
        "junit:src/test/resources/features/htmlReport/cucumber.xml",
        "rerun:testOutput/failed_scenario.txt"},

        features = "@testOutput/failed_scenario.txt",
        glue = {"techproed/stepDefinitions"},
        //tags = "@rerun", //taga gerek yok
        dryRun = false,

        monochrome = false

        //features dan çalıştırırsak failed_scenario.txt de göstermiyor.
        //runner da çalıştırmak lazım
)
/*
rerun plugin kullanımında plugin parametresinin içine .txt dosyamızın yolunu belirtiriz.
feature parametresinin içine de aynı yolu kopyalarıız ve başına @ işareti koymalıyız.
feature parametresi ile direk dosyayı gördüğü için bu class'ta tags parametresine gerek yoktur.
Böylelikle fail senaryolarımızın ismi ve sastır numarası .txt dosyamızın içine kaydedilir.
Ve failedRun class'ından run yaptığımız zaman .txt dosyamızın içindeki fail olan scenariolar
tekrar çalışacaktır. Fail olan senaryolarıızdaki hata düzeltildikten sonra .txt dosyamızın
içindeki bilgiler silinir.

 */
public class FailedRun {
}
