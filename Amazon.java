package homeassignmentweek4;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {
public static void main(String[] args) throws IOException, InterruptedException {
	ChromeDriver driver = new ChromeDriver();
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	driver.get("https://www.amazon.in/");
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro");
	driver.findElement(By.id("nav-search-submit-button")).click();
	
	WebElement text = driver.findElement(By.xpath("(//span[@class='a-offscreen'])[1]"));
	String text2 = text.getText();
	
	System.out.println(text2);
	
	
	WebElement customerCount = driver.findElement(By.xpath("(//span[@class='a-size-base s-underline-text'])[1]"));
	String cc = customerCount.getText();
	System.out.println("No of customer rated for this item : "+cc);
	
	driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
	
	Set<String> pw = driver.getWindowHandles();
	List<String> cw = new ArrayList<String>(pw);
	
	String cwTitle = driver.switchTo().window(cw.get(1)).getTitle();
	System.out.println("Child Window Title : "+cwTitle);
	
	File scr = driver.getScreenshotAs(OutputType.FILE);
	
	File dest = new File("./ScreenShot/mobile.png");
	
	FileUtils.copyFile(scr, dest);
	
	driver.findElement(By.id("add-to-cart-button")).click();
	
	Thread.sleep(3000);
	
	WebElement subtotal = driver.findElement(By.id("attach-accessory-cart-subtotal"));
	String text3 = subtotal.getText();
	System.out.println("Subtotal : "+text3);
	
	if(text2==text3) {
		System.out.println("Both Total are Correct");
	}else {
		System.out.println("Incorrect Amount");
	}
	
	
	
}
}
