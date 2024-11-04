package pl.testeroprogramowania.tests;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramowania.pages.HomePage;

public class RegisterTest extends BaseTest {

    @Test
    public void registerUserTest() throws InterruptedException {
        int random = (int) (Math.random() * 1000);
        String username = "test" + random + "@test.com";
        ExtentTest extentTest = extentReports.createTest("Register user with username " + username);
        extentTest.pass("Browser opened");
        WebElement dashboardLink = new HomePage(driver)
                .openMyAccountPage()
                .registerUserValidData(username, "test@test.com")
                .getDashboardLink();
        extentTest.pass("Register steps");
        Assert.assertEquals(dashboardLink.getText(), "Dashboard");
        extentTest.pass("Dashboard link displayed");
    }

    @Test
    public void registerExistingUserTest() throws InterruptedException {
        ExtentTest extentTest = extentReports.createTest("Register user with username test@test.com");
        extentTest.pass("Browser opened");
        WebElement error = new HomePage(driver)
                .openMyAccountPage()
                .registerUserInvalidData("test@test.com", "test@test.com")
                .getError();
        extentTest.pass("Register steps");
        Assert.assertTrue(error.getText().contains("An account is already registered with your email address"));
        extentTest.pass("Error message displayed");
    }
}
