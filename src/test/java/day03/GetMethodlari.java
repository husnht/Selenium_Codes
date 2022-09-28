package day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class GetMethodlari {
    public static void main(String[] args) {
        /*
        Amazon sayfasina gidiniz
        Arama kutusunu locate ediniz
        Arama kutusunun tag name'inin input oldugunu test ediniz
        Arama kutusunun name attribute degerinin field-keywords oldugunu test ediniz
        Sayfayi kapatiniz
         */
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        //System.out.println(driver.findElement(By.id("twotabsearchtextbox")).getTagName().contains("input"));

        String expectedTagName="input";
        String actualTagName=aramaKutusu.getTagName();
        if (actualTagName.equals(expectedTagName)){
            System.out.println("TagName Test PASSED");
        }else {
            System.out.println("TagName Test FAILED");
        }

        //Arama kutusunun name attribute degerinin field-keywords oldugunu test ediniz
        String expectedAttributeName="field-keywords";
        String actualAttributeName=aramaKutusu.getAttribute("name");//field-keyworsds'un attribute degeri name
        //webElement.getAttribute(“Att.ismi” ); Ismi girilen attribute’un degerini getirir
        if (actualAttributeName.equals(expectedAttributeName)){
            System.out.println("Attribute Test PASSED");
        }else {
            System.out.println("Attribute Test FAILED");
        }
        //Arama kutusunun konumunu yaziniz
        System.out.println(aramaKutusu.getLocation());
        driver.close();
    }
}
