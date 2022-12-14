package day02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_Odev02 {
    /*
        Yeni bir Class olusturalim.C05_NavigationMethods
        Youtube ana sayfasina gidelim . https://www.youtube.com/
        Amazon soyfasina gidelim. https://www.amazon.com/
        Tekrar YouTube’sayfasina donelim
        Yeniden Amazon sayfasina gidelim
        Sayfayi Refresh(yenile) yapalim
        Sayfayi kapatalim / Tum sayfalari kapatalim
         */
    public static void main(String[] args) throws InterruptedException {
        //Youtube ana sayfasina gidelim . https://www.youtube.com/
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.youtube.com");
        driver.manage().window().maximize();
        //Amazon soyfasina gidelim. https://www.amazon.com/
        Thread.sleep(2000);
        driver.get("https://www.amazon.com");
        //Tekrar YouTube’sayfasina donelim
        Thread.sleep(2000);
        driver.navigate().back();
        //Yeniden Amazon sayfasina gidelim
        Thread.sleep(2000);
        driver.navigate().forward();
        //Sayfayi Refresh(yenile) yapalim
        driver.navigate().refresh();
        //Sayfayi kapatalim / Tum sayfalari kapatalim
        driver.quit();

    }
}
