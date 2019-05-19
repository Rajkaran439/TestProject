package com.redbus.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;



import com.redbus.util.TestBase;



public class HomePage extends TestBase{
	
	String path= System.getProperty("user.dir");

	@FindBy(how = How.XPATH, using ="//input[contains(@id, 'src')]")
	WebElement	txt_sourceLocation_XP;
	
	@FindBy(how = How.XPATH, using ="//li[contains(text(),'Mumbai (All Locations)')]")
	WebElement lbl_sourceLocationOption_XP;
	
	@FindBy(how = How.XPATH, using ="//input[contains(@id, 'dest')]")
	WebElement	txt_destinationLocation_XP;
	
	@FindBy(how = How.CSS, using ="a[title='redBus']")
	WebElement busticketpagelink;
	
	@FindBy(how = How.CSS, using ="a[title='redBus Hotels']")
	WebElement hotelticketpagelink;
	
	@FindBy(how = How.CSS, using ="button#search_btn")
	WebElement searchbusSubmit;
	
	@FindBy(how = How.XPATH, using= "//button[contains(@id, 'search_btn')]")
	WebElement btn_searchBus_XP;
	
	
	@FindBy(how = How.XPATH, using= "//label[@for='dtAfter 6 pm' and @class='custom-checkbox']")
	WebElement chk_after6PM_XP;
	
	@FindBy(how = How.XPATH, using= "//*[@id='filter-block']/div/div[2]/ul[3]/li[4]/label[2]")
	WebElement chk_NONAC_XP;
	
	@FindBy(how = How.XPATH, using="//div[contains(text(),'View Seats')]")
	WebElement btn_viewSeats_XP;
	
	@FindBy(how = How.XPATH, using="//canvas")
	WebElement cnv_seatCanvas_XP;
	
	@FindBy(how = How.XPATH, using= "//a[contains(text(),'HOTELS')]")
	WebElement lnk_hotels_XP;
	
	@FindBy(how = How.XPATH, using="//input[contains(@id, 'onward_cal')]")
	WebElement cal_startDate_XP;
	
	@FindBy(how = How.XPATH, using="//li[contains(@class,'db oh')]/div/div")
	WebElement radio_boardingPoint_XP;
	
	
	@FindBy(how = How.XPATH, using="//span[contains(text(),'INR')]//following-sibling::span")
	WebElement lbl_travelFare_XP;
	
	@FindBy(how = How.XPATH, using="//button[contains(text(),'continue')]")
	WebElement btn_continue_XP;
	
	@FindBy(how = How.XPATH, using="//button[contains(text(),'Proceed to book')]")
	WebElement btn_proceedToBook_XP;
	
	@FindBy(how = How.XPATH, using="//input[contains(@id,'insuranceNotOpted')]//following-sibling::span")
	WebElement radio_insuranceNotOpted_XP;
	
	@FindBy(how = How.XPATH, using="//div[contains(@class,'booking-amt')]/span")
	WebElement lbl_totalAmount_XP;
	
	
	public HomePage(){
		PageFactory.initElements(driver,this);
	}


	public void setSourceLocation(String fro)
	{
		wait.until(ExpectedConditions.elementToBeClickable(txt_sourceLocation_XP));
		txt_sourceLocation_XP.sendKeys(fro);
		wait.until(ExpectedConditions.elementToBeClickable(lbl_sourceLocationOption_XP)).click();
	}
	
	
	public void setDestinationLocation(String to) {
		driver.findElement(By.xpath("//input[contains(@id, 'dest')]")).sendKeys(to);
	}
	
	
	
	public void selectStartDate(String date) throws InterruptedException
	{
		
		cal_startDate_XP.sendKeys(date);
		driver.findElement(By.xpath("//div[@id='rb-calendar_onward_cal']//td[@class='current day'][contains(text(),'"+date+"')]")).click();
		 
	}
	public void clickSearchButton()
	{
		btn_searchBus_XP.click();
	}
	public void clickAfter6PMCheckbox() throws InterruptedException
	{
		wait.until(ExpectedConditions.elementToBeClickable(chk_after6PM_XP)).click();
	}
	public void clickNONACCheckbox()
	{
		chk_NONAC_XP.click();
	}
	public void clickViewSeatButton() throws InterruptedException
	{
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(btn_viewSeats_XP)).click();
	}
	
	public void selectBusSeat() throws FindFailed
	{
		Screen sc=new Screen();
		Pattern available_seat=new Pattern(path+"Busseat.jpg");	
		sc.wait(available_seat,20);
		sc.click(available_seat);
	}
	public void clickHotelsLink()
	{
		wait.until(ExpectedConditions.elementToBeClickable(lnk_hotels_XP)).click();
	}
	public void clickBoardingPoint()
	{
		wait.until(ExpectedConditions.elementToBeClickable(radio_boardingPoint_XP)).click();
	}
	public String getFareValue()
	{
		return lbl_travelFare_XP.getText();
	}
	public void clickContinueButton()
	{
		btn_continue_XP.click();
	}
	public void clickProceedToBookButton()
	{
		wait.until(ExpectedConditions.elementToBeClickable(btn_proceedToBook_XP)).click();
	}
	public void clickInsuranceNotOpted()
	{
		wait.until(ExpectedConditions.elementToBeClickable(radio_insuranceNotOpted_XP)).click();
	}
	public String getTotalAmount()
	{
		return wait.until(ExpectedConditions.elementToBeClickable(lbl_totalAmount_XP)).getText();
	}
	
}
	
