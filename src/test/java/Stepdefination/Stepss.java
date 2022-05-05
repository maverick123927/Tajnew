package Stepdefination;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import PageObject.Homepage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepss {

	Logger logger;
	WebDriver driver;
	Homepage hp;
	@Given("User lunch the Chrome browser")
	public void user_lunch_the_chrome_browser() {
		logger.info("Open broser");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nirnay\\eclipse-workspace\\TajProject\\Driver\\chromedriver.exe");
		driver= new ChromeDriver();
		hp= new Homepage(driver);
	}

	@When("user Enetr URL")
	public void user_enetr_url() {
		logger.info("User enter url");
	    driver.get("https://www.tajhotels.com/");
	}

	@Then("User click on the search bar")
	public void user_click_on_the_search_bar() {
		logger.info("User click search bar ");
		hp.click_search();
	}

	@And("User enter city name")
	public void user_enter_city_name() {
		
		logger.info("Enter city name");
		String city="mumbai";
	    hp.enter_text(city);
	}

	@Then("User find the hotel and click")
	public void user_find_the_hotel_and_click() {
		logger.info("select hotel");
	    hp.selecthotel();
	}

	@And("Verify the head line")
	public void verify_the_head_line() {
		logger.info("verify the head line");
	    driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/main/div[3]/div/div/div[5]/section/div/div[1]/div[1]/div/div[1]/h1/span")).getText();
	    
	}

	@Then("click find discounts")
	public void click_find_discounts() {
		logger.info("verify the dicount oftion");
	    hp.clickoffer();
	    hp.clickview();
	    String line=driver.findElement(By.xpath("/html/body/div[1]/div[2]/main/div[3]/div/div/div[7]/div/div/div/div/div[1]/div[3]/div[2]/div[1]/div[2]")).getText();
	    Assert.assertEquals("Upto 15% Savings on Best Available Rate*", line);
	}

	@And("verify the footer part")
	public void verify_the_footer_part() {
		logger.info("verify the footer part");
	    hp.clickfooter();
	    String line2= driver.findElement(By.xpath("/html/body/div[1]/div[2]/main/div[3]/div/div/div/div[1]/div/div[1]/section/div/h1")).getText();
	    Assert.assertEquals("TOP READS", line2);
	    
	}

	@Then("close the browser")
	public void close_the_browser() {
		logger.info("test finish close browser");
	    driver.close();
	    driver.quit();
	}
}
