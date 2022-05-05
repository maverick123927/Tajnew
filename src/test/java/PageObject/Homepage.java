package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

	public WebDriver ldriver;
	public Homepage(WebDriver rdriver) {
		ldriver= rdriver;
		PageFactory.initElements(rdriver,this);
		
	}
	@FindBy(name="searchbar-global")
	@CacheLookup
	WebElement searchtxt;
	
	@FindBy(xpath="//*[@id=\"website-hotel-result\"]/a[4]")
	@CacheLookup
	WebElement hotelclick;
	
	@FindBy(id="Offers")
	@CacheLookup
	WebElement offerlink;
	
	@FindBy(xpath="/html/body/div[1]/div[2]/main/div[3]/div/div/div[4]/div[3]/div/div[2]/div/div/div[3]/div[2]/div[1]/button")
	@CacheLookup
	WebElement view_btn;
	
	@FindBy(xpath="/html/body/div[1]/div[2]/div[1]/div/div/div/footer/div/div[1]/div/div[2]/div[1]/ul/li[2]/a")
	@CacheLookup
	WebElement footer_btn;
	
	public void click_search() {
		searchtxt.click();
	}
	public void enter_text(String name) {
		searchtxt.sendKeys(name);
	}
	
	public void selecthotel() {
		ldriver.get("https://www.tajhotels.com/en-in/taj/taj-mahal-palace-mumbai/");
	}
	
	public void clickoffer() {
		offerlink.click();
	}
	
	public void clickview() {
		view_btn.click();
	}
	
	public void clickfooter() {
		footer_btn.click();
	}
	
}
