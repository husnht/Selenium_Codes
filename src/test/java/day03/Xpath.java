package day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Xpath {
    public static void main(String[] args) throws InterruptedException {
        /*




         */

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1-https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        //2- Add Element butonuna basin
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@onclick='addElement()']")).click();
        //driver.findElement(By.xpath("//*[text()='Add Element']"));
        //text ile xpath alinca attribute degil text()= ibaresi kullaniliyor. ONEMLI!

        //Delete butonu’nun gorunur oldugunu test edin
        WebElement deleteButonu=driver.findElement(By.xpath("//*[@class='added-manually']"));
        if (deleteButonu.isDisplayed()){
            System.out.println("Delete button test PASSED");
        }else {
            System.out.println("Delete button test FAILED");
        }

        //Delete tusuna basin
        deleteButonu.click();

        //“Add/Remove Elements” yazisinin gorunur oldugunu test edin
        WebElement addRemoveElement=driver.findElement(By.xpath("//h3")); //tag ile xpath
        //WebElement addRemoveElement = driver.findElement(By.xpath("//*[text()='Add/Remove Elements']")); ayni yer
        if (addRemoveElement.isDisplayed()){
            System.out.println("addRemoveElement test PASSED");
        }else {
            System.out.println("addRemoveElement test FAILED");
        }
    }
}
