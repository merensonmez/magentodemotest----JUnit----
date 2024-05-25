import com.aventstack.extentreports.utils.FileUtil;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.sl.draw.geom.PresetGeometries;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;

public class magentodemotest {
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Faker faker = new Faker();
        String fakeName = faker.name().fullName();
        String fakeLastName = faker.name().lastName();
        String fakeEmail = faker.internet().emailAddress();
        String fakePassword = RandomStringUtils.randomAlphanumeric(10);
        String fakePhoneNumber = RandomStringUtils.randomNumeric(11);


        driver.get("https://magento-demo.mageplaza.com/");

        Thread.sleep(1000);
        WebElement acceptCookies = driver.findElement(By.xpath("//button[@id='cookie-consent-btn-accept-all']"));
        acceptCookies.click();

        if (acceptCookies.isDisplayed()){
            System.out.println("Accepted Cookies successfully.");
        }else {
            System.out.println("Accepted cookies!!!");
        }
        WebElement createAccountButton = driver.findElement(By.linkText("Create an Account"));
        createAccountButton.click();
        Thread.sleep(1000);

        driver.findElement(By.id("firstname")).sendKeys(fakeName);
        Thread.sleep(1000);
        driver.findElement(By.id("lastname")).sendKeys(fakeLastName);
        Thread.sleep(1000);
        driver.findElement(By.id("is_subscribed")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("assistance_allowed_checkbox")).click();
        driver.findElement(By.id("email_address")).sendKeys(fakeEmail);
        System.out.println("Generated email: "+fakeEmail);
        Thread.sleep(1000);
        driver.findElement(By.id("password")).sendKeys(fakePassword);
        System.out.println("Generated pass: "+fakePassword);
        Thread.sleep(1000);
        driver.findElement(By.id("password-confirmation")).sendKeys(fakePassword);
        Thread.sleep(1000);
        driver.findElement(By.id("send2")).click();
        Thread.sleep(2000);
        WebElement homepage = driver.findElement(By.xpath("(//img)[1]"));
        homepage.click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//img[@src='https://magento-demo.mageplaza.com/media/wysiwyg/home/home-pants.jpg']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[normalize-space()='New']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[9]//div[2]//ol[1]//li[1]//a[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[normalize-space()='Portia Capri']")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("option-label-size-142-item-171")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("option-label-color-93-item-50")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("product-addtocart-button")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("shopping cart")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@data-role='proceed-to-checkout']")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("company")).sendKeys("ErenSonmez");
        Thread.sleep(1000);
        driver.findElement(By.name("street[0]")).sendKeys("Malatya Yesilyurt");
        Thread.sleep(1000);
        driver.findElement(By.name("street[1]")).sendKeys("Zonguldak Kozlu");
        Thread.sleep(1000);
        WebElement dropdownElement = driver.findElement(By.name("country_id"));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText("Turkey");
        WebElement stateProvince = driver.findElement(By.name("region"));
        Thread.sleep(1000);
        stateProvince.sendKeys("Yesilyurt");
        Thread.sleep(1000);
        driver.findElement(By.name("city")).sendKeys("Malatya");
        Thread.sleep(1000);
        driver.findElement(By.name("postcode")).sendKeys("44000");
        Thread.sleep(1000);
        driver.findElement(By.name("telephone")).sendKeys(fakePhoneNumber);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@class='button action continue primary']")).click();
        Thread.sleep(2000);
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile,new File("CheckoutPage.png"));
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@title='Place Order']")).click();
        Thread.sleep(1000);

        WebElement orderNumber = driver.findElement(By.xpath("//div[@class='page-wrapper']//p[1]"));
        String orderIDNumber = orderNumber.getText();
        System.out.println("" + orderIDNumber);
        Thread.sleep(1000);

        driver.findElement(By.xpath("//span[normalize-space()='Continue Shopping']")).click();
    }
}
