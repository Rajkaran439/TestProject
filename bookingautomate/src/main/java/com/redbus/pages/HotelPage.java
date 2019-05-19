package com.redbus.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;



import com.redbus.util.TestBase;

public class HotelPage extends TestBase {

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'No Thanks')]")
	WebElement btn_NoThanks_XP;
	
	@FindBy(how = How.XPATH, using = "//div[@class='suggestions-box']//div[1]//div[1]//span[2]")
	WebElement optn_select;
	
	
	@FindBy(how = How.XPATH, using = "//div[@id='rb-calendar_checkin_date']//td[@class='wd day'][contains(text(),'23')]")
	WebElement cal_select_date;
	
	@FindBy(how = How.XPATH, using = "//div[@id='rb-calendar_checkout_date']//td[@class='wd day'][contains(text(),'24')]")
	WebElement cal_select_date2;
	
	@FindBy(how = How.XPATH, using ="//input[contains(@id, 'search_key')]")
	WebElement txt_location_XP;
	
	
	@FindBy(how = How.XPATH, using ="//button[contains(@id,'search_hotel')]")
	By btn_searchHotel_XP;
	
	@FindBy(how = How.XPATH, using ="//small[contains(text(),'Mumbai')]")
	By lbl_searchText_XP;
	
	
	@FindBy(how = How.XPATH, using ="//*[@id='location']/li[6]/div/label[1]")
	WebElement chk_location_XP;
	
	@FindBy(xpath = ("//div[contains(@class,'hotel-location truncate')]"))
	WebElement lbl_searchedHotelLocation_XP;
	
	public HotelPage(){
		PageFactory.initElements(driver,this);
	}
	
	
	public void clickButtonNoThanks()
	{
		wait.until(ExpectedConditions.elementToBeClickable(btn_NoThanks_XP)).click();
	}
	public void setSearchLocation(String hotelloc)
	{
		wait.until(ExpectedConditions.elementToBeClickable(txt_location_XP)).sendKeys(hotelloc);
		wait.until(ExpectedConditions.elementToBeClickable(optn_select)).click();
		
	
	}
	public void selectTodaysdate()
	{
		wait.until(ExpectedConditions.elementToBeClickable(cal_select_date)).click();
		wait.until(ExpectedConditions.elementToBeClickable(cal_select_date2)).click();
		driver.findElement(By.xpath("//td[@class='current day'][contains(text(),'24')]"));
	}
	
	public void clickSearchHotelButton()
	{
		driver.findElement(btn_searchHotel_XP).click();
	}
	/*public void clickSearchText()
	{
		driver.findElement(lbl_searchText_XP).click();
	}*/
	public void clickLocationCheckbox()
	{
		wait.until(ExpectedConditions.elementToBeClickable(chk_location_XP)).click();
	}
	public List<WebElement> getSearchedLocation()
	{
		List<WebElement> hotelLocation = driver.findElements(By.xpath("//div[contains(@class,'hotel-location truncate')]"));
		return hotelLocation;
	}
	
}
