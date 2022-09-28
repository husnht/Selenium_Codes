package day02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_ManageMethodlari {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        //Amazon soyfasina gidelim. https://www.amazon.com/
        driver.get("https://amazon.com");

        //Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println("Pencere konumu : "+driver.manage().window().getPosition());//acilan browser'in konumunu verir
        System.out.println("Pencere olcusu : "+driver.manage().window().getSize());//acilan browser'in olculeri

        //Sayfayi simge durumuna getirin
        driver.manage().window().minimize();

        //simge durumunda 3 saniye bekleyip sayfayi maximize yapin
        Thread.sleep(3000);
        driver.manage().window().maximize();

        //Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin
        System.out.println("Yeni pencere konumu : "+driver.manage().window().getPosition());//maximize iken konum olcusu
        System.out.println("Yeni pencere konumu : "+driver.manage().window().getSize());//maximize iken browser'in olculeri

        //Sayfayi fullscreen yapin
        Thread.sleep(3000);
        driver.manage().window().fullscreen();

        //Sayfanin konumunu ve boyutlarini fullscreen durumunda yazdirin
        System.out.println("Fullscreen pencere konumu : "+driver.manage().window().getPosition());//fullscreen iken browser'in konumunu verir
        System.out.println("Fullscreen pencere olcusu : "+driver.manage().window().getSize());//fullscreen iken acilan browser'in olculeri

        //Sayfayi kapatin
        Thread.sleep(3000);
        driver.close();
    }
}
