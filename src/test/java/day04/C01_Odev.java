package day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_Odev {
    /*
     /*
    1-https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
    2- Add Element butonuna 10 kez basinız
    3- 10 kez Add element butonuna basıldığını test ediniz
    4 - Delete butonuna görünmeyene kadar basınız
    5- Delete butonunun görünmediğini test ediniz
    6- Sayfayı kapatınız
     */
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1-https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        //2- Add Element butonuna 10 kez basinız
        WebElement addElementButton=driver.findElement(By.xpath("//*[text()='Add Element']"));
        int sayi=10;
        int sayac=0;
        while (sayac<sayi){
            addElementButton.click();
            sayac++;
        }

        //3- 10 kez Add element butonuna basıldığını test ediniz
        List<WebElement> deleteButton=driver.findElements(By.xpath("//*[@onclick='deleteElement()']"));
        if (deleteButton.size()==10){
            System.out.println("ADD/ELEMENT BUTTON CLICKED 10 TIMES");
        }else {
            System.out.println("ADD/ELEMENT BUTTON DIDN'T CLICKED 10 TIMES");
        }

        //4 - Delete butonuna görünmeyene kadar basınız
        List<WebElement> deleteButon=driver.findElements(By.xpath("//*[@class='added-manually']"));
        //deleteButonListi.stream().forEach(t-> t.click());
        int basmaSayisi=10;
        for (int i=0; i <10 ; i++) {
            deleteButon.get(i).click();
            basmaSayisi--;
        }

        //5- Delete butonunun görünmediğini test ediniz
        String actualResult = driver.findElement(By.className("no-js")).getText();

        if (!actualResult.contains("Delete")){
            System.out.println("Delete Test PASSED");
        }else
            System.out.println("Delete Test FAILED");

        //6- Sayfayı kapatınız
        driver.close();
    }

}
