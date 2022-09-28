package day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_IlkTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        /*
        1-Amazon sayfasina gidiniz
        2-Basligin "Amazon" icerdigini test ediniz
        3-Url'nin "amazon" icerdigini tes ediniz
        4-Sayfayi kapatiniz
         */

        //1-Amazon sayfasina gidiniz
        driver.get("https://amazon.com");
        driver.manage().window().maximize();
        //2-Basligin "Amazon" icerdigini test ediniz
        String istenenKelime="Amazon";
        if (driver.getTitle().contains(istenenKelime)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }
        //3-Url'nin "amazon" icerdigini tes ediniz
        String istenenKelime2="amazon";
        if (driver.getCurrentUrl().contains(istenenKelime2)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }
        driver.close();

    }
}
