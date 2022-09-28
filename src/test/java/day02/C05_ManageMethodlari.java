package day02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_ManageMethodlari {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        /*
        ileride wait konusunu daha genis olarak ele alacagiz
        Bir sayfa acilirken ilk basta sayfanin icerisinde bulunan elementlere gore bir yukleme suresine ihtiyac vardir
        veya bir web elementin kullanilabilmesi icin zamana ihtiyac vardir
        implicitlyWait() bize sayfanin yuklenmesi ve sayfadaki elementlere ulasim icin beklenecek maximum sureyi
        belirleme olanagi tanir
         */
        driver.get("https://www.amazon.com");
        driver.close();
        //implicity, çalısmıyorsa beklemez kapanır.
        //thread.sleep çalışsada çalısmasada verdiginiz saniye kadar bekler.
    }
}
