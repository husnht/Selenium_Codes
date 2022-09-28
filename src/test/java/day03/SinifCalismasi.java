package day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class SinifCalismasi {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //a. http://a.testaddressbook.com adresine gidiniz.
        driver.get("http://a.testaddressbook.com");
        //b. Sign in butonuna basin
        driver.findElement(By.linkText("Sign in")).click();//1 defa kullanacaksak direk locate edip click diyebiliriz
                                                //if gibi yapilarda kullanacaksak web elemente atamaliyiz

        //c. email textbox,password textbox, and signin button elementlerini locate ediniz..
        WebElement emailTextBox=driver.findElement(By.id("session_email"));
        WebElement password=driver.findElement(By.id("session_password"));
        WebElement signin=driver.findElement(By.name("commit"));

        //d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
        //i. Username : testtechproed@gmail.com
        //ii. Password : Test1234!
        emailTextBox.sendKeys("testtechproed@gmail.com");
        password.sendKeys("Test1234!");
        signin.click();

        //e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
        WebElement expectedUserId=driver.findElement(By.className("navbar-text"));
        if (expectedUserId.isDisplayed()){
            System.out.println("ExpectedUser test PASSED"+" "+expectedUserId.getText());
        }else {
            System.out.println("ExpectedUser test FAILED");
        }
        //bir web elementin uzerindeki yaziyi konsolda yazdirabilmek icin get.text() methodu kullanilir
        //String expectedUserYazisi="testtechproed@gmail.com"
        //String actualUserYazisi=expectedUser.getText();
        //if(expectecUserYazisi.equals(actualUserYazisi)){
        //System.out.println("ExpectedUser test PASSED" seklinde de cozulebilir

        //f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).
        WebElement adressess=driver.findElement(By.linkText("Addresses"));
        WebElement signOut=driver.findElement(By.linkText("Sign out"));
        if (adressess.isDisplayed()){
            System.out.println("Adresses test PASSED");
        }else {
            System.out.println("Adresses test FAILED");
        }
        if (signOut.isDisplayed()){
            System.out.println("SignOut test PASSED");
        }else {
            System.out.println("SignOut test FAILED");
        }

        //Sayfada kac tane link oldugunu bulun.
        List<WebElement> linklerListesi=driver.findElements(By.tagName("a"));
        System.out.println(linklerListesi.size());

        //Linkleri yazdiriniz
        //System.out.println(links); yazarsak referans numaralari gelir
        for (WebElement w:linklerListesi
             ) {
            System.out.println(w.getText());
        }

        //lambda ile
        linklerListesi.stream().forEach(t-> System.out.println(t.getText()));
        //driver.findElements(By.tagName("a")).stream().forEach(t-> System.out.println(t.getText()));
        //System.out.println("Link adedi : "+driver.findElements(By.tagName("a")).stream().count());


        driver.close();
    }
}
