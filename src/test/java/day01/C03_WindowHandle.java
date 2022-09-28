package day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_WindowHandle {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://amazon.com");
        driver.manage().window().maximize();
        System.out.println(driver.getWindowHandle());//CDwindow-E91EC511697DC35A0F29FBFE5C3D3663
        //farkli pencereler arasinda gezinebilmek icin getwindowhandle() methodunu kullaniriz
    }
}
