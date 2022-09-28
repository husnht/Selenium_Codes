package day01;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05_NavigateMethodlari {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://amazon.com");
        //driver.navigate().to() merhodu sayfada ileri geri yapacaksak kullanilir
        //driver.get() merhodu gibi bizi istedigimiz Url'e goturur
        driver.navigate().to("https://www.techproeducation.com");
        //Tekrar amazon sayfasina donelim
        Thread.sleep(3000);
        driver.navigate().back();
        //tekrar techpro sayfasina gidelim
        Thread.sleep(3000);
        driver.navigate().forward();
        //sayfayi yenileyelim
        Thread.sleep(3000);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); dene
        driver.navigate().refresh();
        //sayfayi kapatalim
        driver.close();
    }
}
