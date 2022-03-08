package Resource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseBrowser {
	public WebDriver driver;

	public WebDriver initialBrowser() throws IOException {

		Properties properties = new Properties();

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/java/Resource/data.properties");
		properties.load(fis);
		String browser = properties.getProperty("browser");
		System.out.println(browser);

		if (browser.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/drivers/chrome/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.contains("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "/drivers/Firefox/geckodriver.exe");
			driver = new FirefoxDriver();

		} else {
			System.setProperty("webdriver.edge.driver",
					System.getProperty("user.dir") + "/drivers/Edge/msedgedriver.exe");
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
	}

}
