import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationFirstTest {
    //SHARELANE-4  registration with only required fields
    @Test
    public void onlyRequiredFields() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=55555");

        WebElement firstNameInput = driver.findElement(By.name("first_name"));
        firstNameInput.sendKeys("Andrei");
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("ad@mail.ru");
        WebElement passwordInput = driver.findElement(By.name("password1"));
        passwordInput.sendKeys("1234");
        WebElement confirmPasswordInput = driver.findElement(By.name("password2"));
        confirmPasswordInput.sendKeys("1234");
        driver.findElement(By.cssSelector("input[value='Register']")).click();

        WebElement successRegistrationMessage = driver.findElement(By.xpath("//span[text( )= 'Account is created!']"));
        Assert.assertTrue(successRegistrationMessage.isDisplayed(), "New page don't opened");
        driver.quit();
    }
    @Test
    public void allFields() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=55555");

        WebElement firstNameInput = driver.findElement(By.name("first_name"));
        firstNameInput.sendKeys("Andrei");
        WebElement lastNameInput = driver.findElement(By.name("last_name"));
        lastNameInput.sendKeys("Anufrik");
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("ad@mail.ru");
        WebElement passwordInput = driver.findElement(By.name("password1"));
        passwordInput.sendKeys("1234");
        WebElement confirmPasswordInput = driver.findElement(By.name("password2"));
        confirmPasswordInput.sendKeys("1234");
        driver.findElement(By.cssSelector("input[value='Register']")).click();

        WebElement successRegistrationMessage = driver.findElement(By.xpath("//span[text( )= 'Account is created!']"));
        Assert.assertTrue(successRegistrationMessage.isDisplayed(), "New page don't opened");
        driver.quit();
    }
    @Test
    public void withoutPassword() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=55555");

        WebElement firstNameInput = driver.findElement(By.name("first_name"));
        firstNameInput.sendKeys("Andrei");
        WebElement lastNameInput = driver.findElement(By.name("last_name"));
        lastNameInput.sendKeys("Anufrik");
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("ad@mail.ru");
        WebElement passwordInput = driver.findElement(By.name("password1"));
        passwordInput.sendKeys("");
        WebElement confirmPasswordInput = driver.findElement(By.name("password2"));
        confirmPasswordInput.sendKeys("1234");
        driver.findElement(By.cssSelector("input[value='Register']")).click();

        WebElement errorRegistrationMessage = driver.findElement(By.xpath("//span[contains(text(), 'invalid data')]"));
        Assert.assertTrue(errorRegistrationMessage.isDisplayed(),"New page don't opened");
        Assert.assertEquals(errorRegistrationMessage.getText(),"Oops, error on page. Some of your fields have " +
                "invalid data or email was previously used","Check text");
        driver.quit();
    }

    @Test
    public void withoutFirstName() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=55555");

        WebElement firstNameInput = driver.findElement(By.name("first_name"));
        firstNameInput.sendKeys("");
        WebElement lastNameInput = driver.findElement(By.name("last_name"));
        lastNameInput.sendKeys("Anufrik");
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("ad@mail.ru");
        WebElement passwordInput = driver.findElement(By.name("password1"));
        passwordInput.sendKeys("1234");
        WebElement confirmPasswordInput = driver.findElement(By.name("password2"));
        confirmPasswordInput.sendKeys("1234");
        driver.findElement(By.cssSelector("input[value='Register']")).click();

        WebElement errorRegistrationMessage = driver.findElement(By.xpath("//span[contains(text(), 'invalid data')]"));
        Assert.assertTrue(errorRegistrationMessage.isDisplayed(),"New page don't opened");
        Assert.assertEquals(errorRegistrationMessage.getText(),"Oops, error on page. Some of your fields have " +
                "invalid data or email was previously used","Check text");
        driver.quit();
    }
    @Test
    public void withoutEmail() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=55555");

        WebElement firstNameInput = driver.findElement(By.name("first_name"));
        firstNameInput.sendKeys("Andrei");
        WebElement lastNameInput = driver.findElement(By.name("last_name"));
        lastNameInput.sendKeys("Anufrik");
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("");
        WebElement passwordInput = driver.findElement(By.name("password1"));
        passwordInput.sendKeys("1234");
        WebElement confirmPasswordInput = driver.findElement(By.name("password2"));
        confirmPasswordInput.sendKeys("1234");
        driver.findElement(By.cssSelector("input[value='Register']")).click();

        WebElement errorRegistrationMessage = driver.findElement(By.xpath("//span[contains(text(), 'invalid data')]"));
        Assert.assertTrue(errorRegistrationMessage.isDisplayed(),"New page don't opened");
        Assert.assertEquals(errorRegistrationMessage.getText(),"Oops, error on page. Some of your fields have " +
                "invalid data or email was previously used","Check text");
        driver.quit();
    }
}
