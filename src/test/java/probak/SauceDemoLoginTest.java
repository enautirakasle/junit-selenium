package probak;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class SauceDemoLoginTest {
	public static WebDriver driver;

	@BeforeAll
	static void before_all() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
	}

	@BeforeEach
	void setUp() throws Exception {
		driver.get("http://www.saucedemo.com");
	}

	@Test
	@DisplayName("Login con usuario correcto")
	void testLoginOk() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		String products = "";
		products = driver.findElement(By.className("title")).getText();
		
		assertEquals("Products", products);
	}
	
	@Test
	@DisplayName("Login con usuario incorrecto")
	void testLoginNOk() {
		driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		String mensajeError = "";
		mensajeError = driver.findElement(By.className("error-message-container")).getText();
		
		assertTrue(mensajeError.contains("locked out"));
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.manage().deleteAllCookies();
	}

	@AfterAll
	static void after_all() {
		if (driver != null) {
			driver.quit();
		}
	}

}
