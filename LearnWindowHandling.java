package homeassignmentweek4;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnWindowHandling {
	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();

		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();

		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
		Set<String> pw = driver.getWindowHandles();
		List<String> window = new ArrayList<String>(pw);
		String title = driver.switchTo().window(window.get(1)).getTitle();
		System.out.println(title);

		driver.findElement(By.xpath("(//a[@class='linktext'])[3]")).click();

		Set<String> pw1 = driver.getWindowHandles();
		List<String> window1 = new ArrayList<String>(pw1);

		driver.switchTo().window(window1.get(0));
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();

		/*
		 * String title2 = driver.switchTo().window(window1.get(1)).getTitle();
		 * System.out.println(title2);
		 */
		Set<String> pw2 = driver.getWindowHandles();
		List<String> window2 = new ArrayList<String>(pw2);
		driver.switchTo().window(window2.get(1));

		driver.findElement(By.xpath("(//a[@class='linktext'])[12]")).click();
		Set<String> pw3 = driver.getWindowHandles();
		List<String> window3 = new ArrayList<String>(pw3);
		driver.switchTo().window(window3.get(0));

		driver.findElement(By.xpath("//a[text()='Merge']")).click();

		Alert alert = driver.switchTo().alert();
		alert.accept();

		String title2 = driver.getTitle();
		System.out.println("Verifying the title of this page : " + title2);

	}
}
