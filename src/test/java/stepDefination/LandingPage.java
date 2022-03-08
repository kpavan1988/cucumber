package stepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Resource.BaseBrowser;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.LoginPage;

public class LandingPage extends BaseBrowser {
	LoginPage LP;

	@Given("^initailize the browser$")
	public void initailize_the_browser() throws Throwable {

		System.out.println("hi everyone");

		driver = initialBrowser();
	}

	@Given("^by using link \"([^\"]*)\"$")
	public void by_using_link(String arg1) throws Throwable {
		driver.get(arg1);

	}

	@When("^CLick on login button$")
	public void click_on_login_button() throws Throwable {
		LP = new LoginPage(driver);
		LP.loginButton();

	}

	@And("^Enter (.+) and (.+) submit$")
	public void enter_and_submit(String username, String password) throws Throwable {
		LP.userName().sendKeys(username);
		LP.PassWord().sendKeys(password);
		LP.Submit().click();
		Thread.sleep(1000);
		

	}

	@And("^search the product and select the product$")
	public void search_the_product_and_select_the_product() throws Throwable {
		LP.Search();
		LP.Find();
		
		LP.selectProduct();

	}
      
	@When("^add to the cart and plac the order$")
	public void add_to_the_cart_and_plac_the_order() throws Throwable {
		LP.BuyNow().click();;
		//LP.PlaceOrder().click();;
	}


	

	@Then("^user should go to home page$")
	public void user_should_go_to_home_page() throws Throwable {
		

	}

}
