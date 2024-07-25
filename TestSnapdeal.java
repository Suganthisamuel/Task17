
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class TestSnapdeal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String email = "suganthi123@gmail";
		String password = "12345678";
		
		System.setProperty("Webdriver.chrome.driver","C:\\Users\\joesa\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		WebDriver driver = new ChromeDriver(options);
		
		try {
			
			driver.get("https://www.snapdeal.com");
			
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			WebElement signInButton = driver.findElement(By.xpath("//div[@class='accountInner']"));
			Actions actions = new Actions(driver);
			actions.moveToElement(signInButton).perform();
			
			signInButton.click();
			
			TimeUnit.SECONDS.sleep(2);
			
			WebElement emailField = driver.findElement(By.id("userName"));
			emailField.sendKeys(email);
			
			WebElement continueButton = driver.findElement(By.id("checkuser"));
			continueButton.click();
			
			TimeUnit.SECONDS.sleep(2);
			
			WebElement passwordField = driver.findElement(By.id("Suganthi_s"));
			passwordField.sendKeys(password);
			
			WebElement loginButton = driver.findElement(By.id("submitlogin"));
			loginButton.click();
			
			TimeUnit.SECONDS.sleep(5);
			
			WebElement accountElement = driver.findElement(By.xpath("//div[@class='accountInner']"));
			if(accountElement.isDisplayed()) {
				System.out.println("Login successful, Verfication Message: User Loginin Succesfully");
			} else {
				System.out.println("Login failed, Verfication Message: User Loginin unsuccesfully");
			}
			
			
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		finally {
			// TODO: handle finally clause
			driver.close();
		}
		
		

	}

}
