import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.sl.draw.geom.PresetGeometries;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.time.Duration;

public class magentodemotest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Faker faker = new Faker();
        String fakeName = faker.name().fullName();
        String fakeLastName = faker.name().lastName();
        String fakeEmail = faker.internet().emailAddress();
        String fakePassword = RandomStringUtils.randomAlphanumeric(10);

        driver.get("https://magento-demo.mageplaza.com/");

        Thread.sleep(1000);
        WebElement acceptCookies = driver.findElement(By.xpath("//button[@id='cookie-consent-btn-accept-all']"));
        acceptCookies.click();

        if (acceptCookies.isDisplayed()){
            System.out.println("Accepted Cookies successfully.");
        }else {
            System.out.println("Accepted cookies!!!");
        }
        WebElement createAccountButton = driver.findElement(By.id("idIhFKvONA"));
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

    }
}
