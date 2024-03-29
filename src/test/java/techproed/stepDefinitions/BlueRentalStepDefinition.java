package techproed.stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import techproed.pages.BlueRentalPage;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;

import java.util.Map;

public class BlueRentalStepDefinition {

    BlueRentalPage blueRentalPage;

    @Then("verilen_kullanici_ile_login_olunur")
    public void verilen_kullanici_ile_login_olunur(DataTable data) {
        blueRentalPage = new BlueRentalPage();
        blueRentalPage.login.click();
        ReusableMethods.bekle(2);
        blueRentalPage.email.sendKeys(data.row(1).get(0), Keys.TAB, data.row(1).get(1), Keys.ENTER);
        ReusableMethods.bekle(3);
        Assert.assertEquals(blueRentalPage.userDropDown.getText(), "Sam Walker");
        Driver.getDriver().navigate().back(); //logout işlemi yerine navigate().back() methodu ile çözdük
        ReusableMethods.bekle(3);

        blueRentalPage.email.sendKeys(data.row(2).get(0), Keys.TAB, data.row(2).get(1), Keys.ENTER);
        ReusableMethods.bekle(3);

        Assert.assertEquals(blueRentalPage.userDropDown.getText(), "Kate Brown");

        ReusableMethods.bekle(5);

    }

    @Then("verilen_kullanicilar_ile_login_olunur")
    public void verilen_kullanicilar_ile_login_olunur(DataTable data) {

        blueRentalPage = new BlueRentalPage();
        System.out.println(data.asMaps()); //Map'larden oluşan bir List oluşturur.
        //Feature file'daki oluşturmuş olduğumuz tabloyu map olarak listeler.
        //Başlığı key olarak alır.Altındaki verileri value olarak alır.
        //[{email=sam.walker@bluerentalcars.com, password=c!fas_art}, {email=kate.brown@bluerentalcars.com, password=tad1$Fas}]
        for (Map<String, String> w : data.asMaps()) {
            blueRentalPage.login.click();
            blueRentalPage.email.sendKeys(w.get("email"), Keys.TAB, w.get("password"), Keys.ENTER);
            ReusableMethods.bekle(2);
            blueRentalPage.userDropDown.click();
            ReusableMethods.bekle(2);
            blueRentalPage.logout.click();
            ReusableMethods.bekle(2);
            blueRentalPage.ok.click();

        }


    }

    @And("kullanici_exceldeki_{string}_sayfasindaki_kullanici_bilgileri_ile_login_olur")
    public void kullanici_exceldeki__sayfasindaki_kullanici_bilgileri_ile_login_olur(String sayfaAdi) {
        blueRentalPage = new BlueRentalPage();
        ExcelUtils excelUtils = new ExcelUtils("src/test/resources/mysmoketestdata.xlsx", sayfaAdi);
        for (int i = 1; i <= excelUtils.rowCount(); i++) {
            String email = excelUtils.getCellData(i, 0);
            String password = excelUtils.getCellData(i, 1);
            blueRentalPage.login.click();
            ReusableMethods.bekle(2);
            blueRentalPage.email.sendKeys(email, Keys.TAB, password, Keys.ENTER);
            ReusableMethods.bekle(2);
            blueRentalPage.userDropDown.click();
            ReusableMethods.bekle(2);
            blueRentalPage.profile.click();
            ReusableMethods.bekle(2);
            Assert.assertEquals(blueRentalPage.verifyEmail.getText(), email);
            ReusableMethods.bekle(2);
            blueRentalPage.userDropDown.click();
            ReusableMethods.bekle(2);
            blueRentalPage.logout.click();
            ReusableMethods.bekle(2);
            blueRentalPage.ok.click();


        }


    }

    @Given("kullanici_blueRentACarsUrl_sayfasina_gider_exceldeki_verilerle_login_olur")
    public void kullanici_bluerentacarsurl_sayfasina_gider_exceldeki_verilerle_login_olur() {
        System.out.println("BluRentalPage Sayfasına Gidildi Exceldeki veriler ile login olundu");
    }
}
