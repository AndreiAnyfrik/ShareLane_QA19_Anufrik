import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegistrationFirstTest extends BaseTest {
    @DataProvider
    public Object[][] validRegistration() {
        return new Object[][]{
                {"aa", "ad@mail.ru", "12345", "12345"},
                {"sadsda", "sd@mail.ru", "123456", "123456"}
        };
    }

    @Test(dataProvider = "validRegistration")
    public void positiveTest(String firstName, String email, String password, String confirmPassword) {
        driver.findElement(By.name("first_name")).sendKeys(firstName);
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password1")).sendKeys(password);
        driver.findElement(By.name("password2")).sendKeys(confirmPassword);
        driver.findElement(By.cssSelector("input[value='Register']")).click();
        WebElement successRegistrationMessage = driver.findElement(By.xpath("//span[text( )= 'Account is created!']"));
        Assert.assertTrue(successRegistrationMessage.isDisplayed(), "New page don't opened");
    }


    @Test
    public void onlyRequiredFields() {
        driver.findElement(By.name("first_name")).sendKeys("Andrei");
        driver.findElement(By.name("email")).sendKeys("ad@mail.ru");
        driver.findElement(By.name("password1")).sendKeys("1234");
        driver.findElement(By.name("password2")).sendKeys("1234");
        driver.findElement(By.cssSelector("input[value='Register']")).click();
        WebElement successRegistrationMessage = driver.findElement(By.xpath("//span[text( )= 'Account is created!']"));
        Assert.assertTrue(successRegistrationMessage.isDisplayed(), "New page don't opened");
    }

    @Test
    public void allFields() {
        driver.findElement(By.name("first_name")).sendKeys("Andrei");
        driver.findElement(By.name("last_name")).sendKeys("Anufrik");
        driver.findElement(By.name("email")).sendKeys("ad@mail.ru");
        driver.findElement(By.name("password1")).sendKeys("1234");
        driver.findElement(By.name("password2")).sendKeys("1234");
        driver.findElement(By.cssSelector("input[value='Register']")).click();
        WebElement successRegistrationMessage = driver.findElement(By.xpath("//span[text( )= 'Account is created!']"));
        Assert.assertTrue(successRegistrationMessage.isDisplayed(), "New page don't opened");
        driver.quit();
    }

    @DataProvider
    public Object[][] invalidRegistration() {
        return new Object[][]{
                {"", "ad@mail.ru", "12345", "12345"},
                {"sadsda", "", "123456", "123456"},
                {"asdas", "fd@mail.ru", "234", "1234"}
        };
    }

    @Test(dataProvider = "invalidRegistration")
    public void negativeTest(String firstName, String email, String password, String confirmPassword) {
        driver.findElement(By.name("first_name")).sendKeys(firstName);
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password1")).sendKeys(password);
        driver.findElement(By.name("password2")).sendKeys(confirmPassword);
        driver.findElement(By.cssSelector("input[value='Register']")).click();
        WebElement errorRegistrationMessage = driver.findElement(By.xpath("//span[contains(text(), 'invalid data')]"));
        Assert.assertTrue(errorRegistrationMessage.isDisplayed(), "New page don't opened");
        Assert.assertEquals(errorRegistrationMessage.getText(), "Oops, error on page. Some of your fields have " +
                "invalid data or email was previously used", "Check text");
    }

    @Test
    public void withoutPassword() {
        driver.findElement(By.name("first_name")).sendKeys("Andrei");
        driver.findElement(By.name("last_name")).sendKeys("Anufrik");
        driver.findElement(By.name("email")).sendKeys("ad@mail.ru");
        driver.findElement(By.name("password1")).sendKeys("");
        driver.findElement(By.name("password2")).sendKeys("1234");
        driver.findElement(By.cssSelector("input[value='Register']")).click();
        WebElement errorRegistrationMessage = driver.findElement(By.xpath("//span[contains(text(), 'invalid data')]"));
        Assert.assertTrue(errorRegistrationMessage.isDisplayed(), "New page don't opened");
        Assert.assertEquals(errorRegistrationMessage.getText(), "Oops, error on page. Some of your fields have " +
                "invalid data or email was previously used", "Check text");
    }

    @Test
    public void withoutFirstName() {
        driver.findElement(By.name("first_name")).sendKeys("");
        driver.findElement(By.name("last_name")).sendKeys("Anufrik");
        driver.findElement(By.name("email")).sendKeys("ad@mail.ru");
        driver.findElement(By.name("password1")).sendKeys("1234");
        driver.findElement(By.name("password2")).sendKeys("1234");
        driver.findElement(By.cssSelector("input[value='Register']")).click();
        WebElement errorRegistrationMessage = driver.findElement(By.xpath("//span[contains(text(), 'invalid data')]"));
        Assert.assertTrue(errorRegistrationMessage.isDisplayed(), "New page don't opened");
        Assert.assertEquals(errorRegistrationMessage.getText(), "Oops, error on page. Some of your fields have " +
                "invalid data or email was previously used", "Check text");
        driver.quit();
    }

    @Test
    public void withoutEmail() {
        driver.findElement(By.name("first_name")).sendKeys("Andrei");
        driver.findElement(By.name("last_name")).sendKeys("Anufrik");
        driver.findElement(By.name("email")).sendKeys("");
        driver.findElement(By.name("password1")).sendKeys("1234");
        driver.findElement(By.name("password2")).sendKeys("1234");
        driver.findElement(By.cssSelector("input[value='Register']")).click();
        WebElement errorRegistrationMessage = driver.findElement(By.xpath("//span[contains(text(), 'invalid data')]"));
        Assert.assertTrue(errorRegistrationMessage.isDisplayed(), "New page don't opened");
        Assert.assertEquals(errorRegistrationMessage.getText(), "Oops, error on page. Some of your fields have " +
                "invalid data or email was previously used", "Check text");
    }
}
