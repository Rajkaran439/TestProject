package com.qa.stepDefinations;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import org.testng.Assert;

import com.redbus.pages.HomePage;
import com.redbus.pages.HotelPage;
import com.redbus.util.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepsToExecute extends TestBase {
	
	HomePage homepage;
	HotelPage hotelpage;
	String Fare,Totalfare;
	
	@Given("^User opens browser and url$")
	public void user_opens_browser_and_url() throws Throwable {
	   TestBase.initialization();
	}


@Then("^User enter \"([^\"]*)\" in source$")
public void user_enter_in_source(String source) throws Throwable {
	homepage = new HomePage();
	homepage.setSourceLocation(source);
	
	
}

@Then("^User enter \"([^\"]*)\" in destination$")
public void user_enter_in_destination(String dest) throws Throwable {
	homepage = new HomePage();
	homepage.setDestinationLocation(dest);

}
	@Then("^user select the date$")
	public void user_select_the_date() throws Throwable {
		homepage = new HomePage();
		homepage.selectStartDate("20");
	}

	@Then("^user search for the buses$")
	public void user_search_for_the_buses() throws Throwable {
		homepage = new HomePage();
		homepage.clickSearchButton();
	}

	@Then("^user select time as After(\\d+)pm$")
	public void user_select_time_as_After_pm(int arg1) throws Throwable {
		homepage = new HomePage();
		homepage.clickAfter6PMCheckbox();
	}

	@Then("^user select bus type as NonAc$")
	public void user_select_bus_type_as_NonAc() throws Throwable {
		homepage = new HomePage();
		homepage.clickNONACCheckbox();
	}

	@Then("^user search for the seats$")
	public void user_search_for_the_seats() throws Throwable {
		homepage = new HomePage();
		homepage.clickViewSeatButton();
	}

	@Then("^User select the seats$")
	public void user_select_the_seats() throws Throwable {
		homepage = new HomePage();
		homepage.selectBusSeat();
	  
	}

	@Then("^User select the boarding and dropping point$")
	public void user_select_the_boarding_and_dropping_point() throws Throwable {
		homepage = new HomePage();
		homepage.clickBoardingPoint();
	}


@Then("^user get the Fare value$")
public void user_get_the_Fare_value() throws Throwable {
	homepage = new HomePage();	
	Fare = homepage.getFareValue();
		
	}


@Then("^user navigate to proceed to book button$")
public void user_navigate_to_proceed_to_book_button() throws Throwable {
	homepage = new HomePage();
	homepage.clickContinueButton();
	homepage.clickProceedToBookButton();
}

	@Then("^user will not opt for insurance$")
	public void user_will_not_opt_for_insurance() throws Throwable {
		homepage = new HomePage();
		homepage.clickInsuranceNotOpted();
	}

	@Then("^user will verify fare on different pages$")
	public void user_will_verify_fare_on_different_pages() throws Throwable {
		homepage = new HomePage();
		Totalfare = homepage.getTotalAmount();
		Assert.assertEquals(Fare, Totalfare);
		
		
	}
	

	@When("^user click on hotel link$")
	public void user_click_on_hotel_link() throws Throwable {
		
		homepage = new HomePage();
		hotelpage=new HotelPage();
		homepage.clickHotelsLink();
		hotelpage.clickButtonNoThanks();
		
		
	    
	}

	@Then("^user enter \"([^\"]*)\" in hotelarea searchbox$")
	public void user_enter_in_hotelarea_searchbox(String location1) throws Throwable {
		hotelpage=new HotelPage();
		hotelpage.setSearchLocation(location1);
		hotelpage.selectTodaysdate();
		
		
	}
	
	@Then("^user select Location as andheri$")
	public void user_select_Location_as_andheri() throws Throwable
	 {
		
		hotelpage=new HotelPage();
		
		hotelpage.clickSearchHotelButton();
		
	}

	@Then("^user verify hotel displayed are of Andheri location$")
	public void user_verify_hotel_displayed_are_of_Andheri_location() throws Throwable {
		hotelpage=new HotelPage();
		try{
		hotelpage.clickLocationCheckbox();
		for(WebElement location : hotelpage.getSearchedLocation())
		{
			Assert.assertEquals(location.getText(), "Andheri, Mumbai");
		}
	}
	catch(Exception e){}
	
	finally{
		
		driver.close();
	}
		
	}
	


}
