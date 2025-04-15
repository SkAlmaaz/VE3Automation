package ve3.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
	
public class TestHomePage {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ve3.global/#elementor-action%3Aaction%3Dpopup%3Aopen%26settings%3DeyJpZCI6Ijc0MjE0IiwidG9nZ2xlIjpmYWxzZX0%3D");

        String title = driver.getTitle();
        if (title.toLowerCase().contains("ve3")) {
            System.out.println("Homepage loaded successfully: PASS");
        } else {
            System.out.println("Homepage not loaded: FAIL");
        }

             /*   driver.findElement(By.xpath("//*[@id=\"b\"]/div[2]/div[3]/div/div/div/div/a/i")).click();
                Thread.sleep(1000); // Wait for input to appear

                driver.findElement(By.className("hfe-search-form__input")).sendKeys("cloud\n");

                driver.findElement(By.className("hfe-search-submit")).click();
                Thread.sleep(3000); // wait for results
*/
                driver.findElement(By.xpath("//*[@id=\"main\"]/div/section[1]/div[3]/div/div/div[3]/div/div/a")).click();
                Thread.sleep(2000);

                driver.findElement(By.id("00NSq000003CM1R")).sendKeys("Mohammed Almaaz Shaikh");
                Thread.sleep(2000);
                driver.findElement(By.id("email")).sendKeys("maazshaikh078@gmail.com");
                Thread.sleep(2000);
                driver.findElement(By.name("description")).sendKeys("I'm interested in your services.");
                Thread.sleep(2000);
                driver.findElement(By.className("recaptcha-checkbox-border")).click();
                Thread.sleep(2000);
                driver.findElement(By.name("submit")).click();
                Thread.sleep(2000);
                System.out.println("Contact form submitted (valid data): Check UI manually for confirmation.");


        driver.quit();
    }
}

