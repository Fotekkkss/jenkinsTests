package pl.testeroprogramowania.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramowania.pages.HomePage;

public class LogInTest extends BaseTest {


    @Test
    public void logInTest() throws InterruptedException {
        int random = (int) (Math.random() * 1000);

        WebElement dashboardLink = new HomePage(driver)
                .openMyAccountPage()
                .logInValidData("test1@test.com", "test@test.com")
                .getDashboardLink();

        Assert.assertEquals(dashboardLink.getText(), "Dashboard");

    }

    // app blocks you after 3 failed attempts
    /*@Test
    public void logInWithInvalidDataTest() throws InterruptedException {

        WebElement error = new HomePage(driver)
                .openMyAccountPage()
                .logInInvalidData("test222@test.com", "tes@test.com")
                .getError();


        Assert.assertTrue(error.getText().contains(": Incorrect username or password."));
        //Assert.assertTrue(error.getText().contains("Too many failed login attempts"));
        System.out.println(error.getText());
    }*/
}
