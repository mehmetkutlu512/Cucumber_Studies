package techproed.stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import techproed.pages.BlueRentalPage;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

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
}
