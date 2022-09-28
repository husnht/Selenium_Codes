package day02;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C10_Odev04 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title) "facebook"
        //        oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.
        driver.get("https://www.facebook.com");
        String sayfaTitle="facebook";
        if (driver.getTitle().contains(sayfaTitle)){
            System.out.println("Facebook baslik testi PASSED");
        }else {
            System.out.println("Facebook sayfa basligi : "+driver.getTitle());
        }

        //Sayfa URL'inin "facebook" kelimesi icerdigini dogrulayin, icermiyorsa "actual" URL'i
        //        yazdirin.
        String sayfaUrl="facebook";
        if (driver.getCurrentUrl().contains(sayfaUrl)){
            System.out.println("Url Test PASSED");
        }else {
            System.out.println("Actual url : "+driver.getCurrentUrl());
        }

        //https://www.walmart.com/ sayfasina gidin.
        driver.navigate().to("https://www.walmart.com/");

        //Sayfa basliginin "Walmart.com" icerdigini dogrulayin.
        String sayfaBaslik="Walmart.com";
        if (driver.getTitle().contains(sayfaBaslik)){
            System.out.println("Baslik testi PASSED");
        }else{
            System.out.println("Baslik testi FAILED");
        }

        //Tekrar "facebook" sayfasina donun
        driver.navigate().back();

        //Sayfayi yenileyin
        driver.navigate().refresh();

        //Sayfayi tam sayfa (maximize) yapin
        driver.manage().window().maximize();

        //Browser'i kapatin
        driver.close();
    }
}
