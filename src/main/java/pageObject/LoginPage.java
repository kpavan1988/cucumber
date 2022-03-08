package pageObject;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.Iterators;

public class LoginPage {
	WebDriver driver;

	By login = By.xpath("//a[contains(text(),'Login')]");
	By username = By.xpath("//body/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/input[1]");
	By password = By.xpath("//body/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/input[1]");
	By submit = By.xpath("//body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[4]/button[1]");
	By search = By.xpath("//body/div[@id='container']/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/input[1]");
	By searhIcon = By
			.xpath("//body/div[@id='container']/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/button[1]/*[1]");
	By product = By.xpath(
			"//body/div[@id='container']/div[1]/div[3]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/a[1]/div[1]/div[1]/div[1]/div[1]/img[1]");
	By bynow=By.xpath("//body/div[@id='container']/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[2]/form[1]/button[1]");
	By order=By.xpath("//form[@action='https://www.flipkart.com/checkout/init?loginFlow=true']");
	

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	Actions a;;

	public WebElement loginButton() {
		return driver.findElement(login);
	}

	public WebElement userName() {
		return driver.findElement(username);
	}

	public WebElement PassWord() {
		return driver.findElement(password);
	}

	public WebElement Submit() {
		return driver.findElement(submit);
	}

	public void Search() {
		a = new Actions(driver);

		a.moveToElement(driver.findElement(search)).click().sendKeys("mobiles").build().perform();

	}

	public void Find() {
		a.moveToElement(driver.findElement(searhIcon)).click().build().perform();
		// new WebDriverWait(driver,
		// 20).until(ExpectedConditions.elementToBeClickable(searhIcon)).click();
		// return driver.findElement(searhIcon);
	}

	public void selectProduct()
	{
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(product)).click();
		//return driver.findElement(product);
	}
	
	public WebElement BuyNow()
	{
		Set<String> TotalWindows=driver.getWindowHandles();
		Iterator<String> window=TotalWindows.iterator();
		String parentWindow=window.next();
		String childwindow=window.next();
		driver.switchTo().window(childwindow);
		System.out.println("added to cart");
		return driver.findElement(bynow);
	}
	
	public WebElement PlaceOrder()
	{
		return driver.findElement(order);
	}

}
