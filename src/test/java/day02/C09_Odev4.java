package day02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C09_Odev4 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını doğrulayın  (verify),
        //eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
        driver.get("https://www.youtube.com");
        if (driver.getTitle().contains("youtube")) {
            System.out.println("Actual Title : youtube");
        } else {
            System.out.println("Actual Title : " + driver.getTitle());
        }
        //Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa doğru  URL'yi yazdırın.
        if (driver.getCurrentUrl().contains("youtube")) {
            System.out.println("TRUE");
        } else {
            System.out.println("Current url : www.youtube.com");
        }
        //Daha sonra Amazon sayfasina gidin https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com");//daha once get ile getirdigimiz bir sayfa varsa ikinci bir
        //url icin navigate kullaniyoruz

        //Youtube sayfasina geri donun
        driver.navigate().back();

        //Sayfayi yenileyin
        driver.navigate().refresh();

        //Amazon sayfasina donun
        driver.navigate().forward();

        //Sayfayi tamsayfa yapin
        driver.manage().window().maximize();

        //Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın, Yoksa  doğru başlığı(Actual Title) yazdırın.
        System.out.println(driver.getTitle());
        if (driver.getTitle().contains("Amazon")) {
            System.out.println("TRUE");
        } else {
            System.out.println("FALSE");
        }

        //Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse doğru
        //        URL'yi yazdırın

        if (driver.getCurrentUrl().equals("https://www.amazon.com/")) {
            System.out.println("TRUE");
        } else {
            System.out.println("Current url : " + driver.getCurrentUrl());

        }
        //Sayfayi kapatin
        driver.close();
    }
}


