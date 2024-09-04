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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BigBasket {
public static void main(String[] args) throws InterruptedException, IOException {
	ChromeDriver driver = new ChromeDriver();
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	driver.get("https://www.bigbasket.com/");
	
	driver.findElement(By.xpath("(//span[text()='Shop by'])[2]")).click();
	
	Actions act = new Actions(driver);
	WebElement moveTo = driver.findElement(By.xpath("(//a[text()='Foodgrains, Oil & Masala'])[2]"));
	act.moveToElement(moveTo).perform();
	
	WebElement moveToRice = driver.findElement(By.xpath("//a[text()='Rice & Rice Products']"));
	act.moveToElement(moveToRice).perform();
	
	WebElement moveToBoiled = driver.findElement(By.xpath("(//a[text()='Boiled & Steam Rice'])[1]"));
	act.moveToElement(moveToBoiled).perform();
	moveToBoiled.click();
	
	Thread.sleep(3000);
	WebElement scrollDown = driver.findElement(By.id("i-BBRoyal"));
	act.scrollToElement(scrollDown).perform();
	scrollDown.click();
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("(//a[@rel='noopener noreferrer'])[5]")).click();
	
	Set<String> pw = driver.getWindowHandles();
	List<String> cw = new ArrayList<String>(pw);
	
	String cwTitle = driver.switchTo().window(cw.get(1)).getTitle();
	Thread.sleep(3000);
	System.out.println("Child Window Title : "+cwTitle);
	
	
	WebElement moveToFive = driver.findElement(By.xpath("(//div[@class='w-40 xl:w-52'])[5]"));
	act.moveToElement(moveToFive).perform();
	moveToFive.click();
	
	WebElement price = driver.findElement(By.xpath("(//span[@class='Label-sc-15v1nk5-0 PackSizeSelector___StyledLabel5-sc-l9rhbt-5 gJxZPQ bvikaK'])[5]"));
	String text = price.getText();
	System.out.println("Price of the rice: "+text);
	
	WebElement moveToBasket = driver.findElement(By.xpath("(//button[text()='Add to basket'])[2]"));
	act.moveToElement(moveToBasket).perform();
	moveToBasket.click();
	//source
   File scr = driver.getScreenshotAs(OutputType.FILE);
   
   //destination
   
   File dest = new File("./ScreenShot/bigbasket.png");
   
   //Combining source and destination
   
   FileUtils.copyFile(scr, dest);
   driver.quit();
   
   }
}
