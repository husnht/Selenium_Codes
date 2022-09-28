package day02;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C07_FindElements {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
        /*
        Diger locatorlerden biraz farklidir, <div> <a> <input> gibi belirli bir etiketle arama yaptigimizda birden fazla
        ayni etikete sahip elementler oldugundan cok sayida oge dondurur. Cok sayida oge dondugu icin de bu locator
        yonteminde findElement degil findElementS yontemi kullanilir. findElementS'i List ile kullanmaliyiz
        By.tagName"a" By.tagName"div" By.tagName"input"... seklinde kullanilir
        */
        //amazon sayfasindaki taglari input olanlarin sayisini yazdiriniz
        //findElementS olacagi icin List yapiyoruz once
        List<WebElement> tag= driver.findElements(By.tagName("input"));
        System.out.println(tag.size());

        //getText ile elementteki yaziyi da alabiliriz
        System.out.println(driver.findElement(By.xpath("(//*[@class='a-color-base headline truncate-2line'])[1]")).getText());
    }
}
