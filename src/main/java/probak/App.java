/**
 * https://www.selenium.dev/documentation/webdriver/getting_started/
 */
package probak;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		// http://www.saucedemo.com
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");

		System.out.println(driver.getTitle());
		
        driver.quit();

	}
}
