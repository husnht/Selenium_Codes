package day02;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_Locators {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.com");

        /*
        *- Web öğesini tanımlamanın en popüler yolu id kullanmaktır
        *- id en güvenli ve en hızlı locator seçeneği olarak kabul edilir ve her zaman birden
        çok locator arasında ilk öncelik olmalıdır.Interview'de web elementini bulma ile ilgili locator sorusu geldiginde
        ilk cevap id olmali fakat kesin cozum XPATH olacaktir
        *- Eğer yanlış id locate edilirse; NoSuchElementException hatası oluşur, boyle bir hata alirsak o satirdaki locator
        kismini kontrol etmemiz gerekir
         */

        //amazon sayfasina gidiniz
        //bunu yapabilmem icin amazondaki arama cubugunun koordinatlarini locate etmem lazim
        //bunu da sag tiklayip incele kismindan yapiyoruz, unique degerleri secmem lazim
        //8 adet var hangisini kullanacagimizi ogrenecegiz
        driver.get("https://amazon.com");

        //Amazonda nutella aratiniz
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));//id'ye gore arama yaparak search box'a geldi
        //aramaKutusu.sendKeys("Nutella");//arama kutusuna Nutella yazdirdi ama henuz aratmadi
        aramaKutusu.sendKeys("Nutella", Keys.ENTER);//arama kutusuna Nutella yazdirdi ve aratti
        //"Nutella", Keys.ENTER yerine "Nutella" + Keys.ENTER da yazilabilir + ya da , farketmez

        /*
        Name ve value unique ise bu metodu da kullanabiliriz ama id varken name tercih edilmez
         */
        WebElement aramaKutusu2=driver.findElement(By.name("field-keywords"));//arama kutusunun name degeri unique oldugu icin calisti
        aramaKutusu2.clear();                                                 //her zaman calismaz
        aramaKutusu2.sendKeys("laptop"+Keys.ENTER);

        /*
        By.className locatoru incele kisminda class ozelligi varsa ve icindeki string unique ise kullanilabilir,
        fakat className genelde ayni islevi yapan bir grup web elementi icin kullanilir ve eger classAttribute degeri
        icinde space yani bosluk varsa saglikli calismaz, asagidaki ornekte class name unique oldugu halde icinde bosluk
        oldugu icin ve web sayfasinda incele diyip class'a tikladigimizda arama kutusunun cercevesini isaretledigi icin
        icine yazi yazamadi ve fail verdi, bir locator calismazsa alternatifleri denenmelidir
         */
        //WebElement aramaKutusu3=driver.findElement(By.className("nav-search-field "));//son karakterde bosluk var
        //aramaKutusu3.clear();
        //aramaKutusu3.sendKeys("table",Keys.ENTER);

        /*
        By.linkText locatoru icin a tag'i kullanilir cunku html de linkleri a tag'iyla aliriz <a>
        HTML link elementleri bir web sayfasinda <a> tag'i kullanilarak temsil edilir
        UI'daki linkleri <a> sayesinde kolayca farkedip bu yontemi kullanabiliriz, buyuk-kucuk harfe duyarlidir
        bir web sayfasindaki linkleri sag tik yapip incele dedikten sonra ctrl+f yapip icine //a yazarak buluruz
         */
        driver.findElement(By.linkText("Sell products on Amazon")).click();//.click ile tiklatiriz
        //partialLinkText ile linkin belli bir parcasi alinarak da arama yapilabilir
        driver.findElement(By.partialLinkText("ducts on Amazon")).click();

    }
}
