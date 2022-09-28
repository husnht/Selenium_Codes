package day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C08_Odev3 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //http://a.testaddressbook.com adresine gidiniz.
        driver.get("http://a.testaddressbook.com");

        //Sign in butonuna basin
        driver.findElement(By.id("sign-in")).click();

        //email textbox,password textbox, and signin button elementlerini locate ediniz..
        // Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
        //        Username : testtechproed@gmail.com
        //        Password : Test1234!
        WebElement emailTextbox=driver.findElement(By.id("session_email"));
        emailTextbox.sendKeys("testtechproed@gmail.com");

        WebElement passwordTextBox=driver.findElement(By.id("session_password"));
        passwordTextBox.sendKeys("Test1234!");

        driver.findElement(By.name("commit")).click();

        //Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
        WebElement expectedUserId=driver.findElement(By.className("navbar-text"));
        if (expectedUserId.isDisplayed()){
            System.out.println("ExpectedUser test PASSED"+" "+expectedUserId.getText());
        }else {
            System.out.println("ExpectedUser test FAILED");
        }

        //“Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).
        WebElement adres = driver.findElement(By.xpath("//*[@id=\"navbar\"]/div[1]/a[2]"));
        if (adres.isDisplayed()){
            System.out.println("Adresses section APPEARS");
        }else {
            System.out.println("Adresses section DOESN'T APPEAR");
        }

        WebElement signOut=driver.findElement(By.xpath("//*[@id=\"navbar\"]/div[1]/a[3]"));
        if (signOut.isDisplayed()){
            System.out.println("Sign out section APPEARS");
        }else {
            System.out.println("Sign out section DOESN'T APPEAR");
        }

        //Sayfada kac tane link oldugunu bulun.
        List<WebElement> tag=driver.findElements(By.tagName("a"));
        System.out.println("Sitede "+ tag.size()+" adet link var");

        //sayfayi kapatin
        driver.close();
    }
}
