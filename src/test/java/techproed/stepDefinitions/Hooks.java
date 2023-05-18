package techproed.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import techproed.utilities.Driver;

public class Hooks {
    /*
        Scenario'lar arasındaki bağlantıyı sağlayan glue parametresine koyduğumuz stepDefinition package'ı içerisinde
    @Before ve @After gibi bir notasyon varsa extend yapmamıza gerek kalmadan her scenariodan önce veya sonra bu
    methodlar çalışacaktır.

        Cucumber'de @Before ve @After kullanma ihtiyacımız olursa bunu Hooks classına koyarız.
        İstersek yeni bir package oluşturup bunun içine de Hooks class'ını koyabiliriz. Eğer yeni bir package içerisine
   koyarsak Runner class'ındaki glue parametresine bu package'ı da eklememiz gerekir.
        Kullandığımız @Before ve @After JUnit'ten değil Cucumber'den olmalıdır.
     */

    @Before("@All")
    public void setUp1() {
        System.out.println("Testler çalışmaya başladı");
    }
    @Before("@gr1")
    public void setUp2()  {
        System.out.println("Amazonda SQL aratıldı");
    }
    @Before("@gr2")
    public void setUp3()  {
        System.out.println("Amazonda Java aratıldı");
    }
    @Before("@gr3")
    public void setUp4()  {
        System.out.println("Amazonda Selenium aratıldı");
    }

    @After //import io.cucumber.java.Scenario;
    public void tearDown(Scenario scenario)  { //Bu methoda Scenario class'ından sonra bir parametre ataması yapılır
        //Bu method'u fail olan scenario'larımızın resmini almak için kullanırız.
        if (scenario.isFailed()){
            TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
            scenario.attach(ts.getScreenshotAs(OutputType.BYTES), "image/jpeg", "screenShot_"+ scenario.getName());
        }
        Driver.closeDriver();

    }
}
