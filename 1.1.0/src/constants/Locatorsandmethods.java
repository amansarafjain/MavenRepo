package com.constants;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


public class Locatorsandmethods extends BaseLibrary {
Robot robot;
public String attachment_path=System.getProperty("user.dir")+System.getProperty("file.separator")+"attachments"+System.getProperty("file.separator");
public String attachment_name1="";
public String attachment_name2="";
public Boolean isPresent ;
public String Quote_name="";
public String opp_name="";
public String note_text="";
public String note_empty_msg="";
public String name="";
public String dynamic_note=RandomStringUtils.randomAlphanumeric(20).toUpperCase();
public String task_name=RandomStringUtils.randomAlphanumeric(4).toUpperCase();



//Methods
public void close_Browser() {
	eventFiringWebDriver.quit();// TODO Auto-generated method stub

}
public void fill_quote_popup() throws InterruptedException{
	eventFiringWebDriver.findElement(By.xpath("//input[@data-widget-path='quoteNumber']")).sendKeys("100");
}
public WebElement new_button() {
	ele=eventFiringWebDriver.findElement(By.xpath("//div[@data-action='New']"));
	return ele;
}
public void create_task_popup_with_attachment() throws InterruptedException, AWTException {
	eventFiringWebDriver.findElement(By.xpath("//div[@class='widget_iform-left-column']/div/ul/li[1]/input")).sendKeys(task_name);
	WebElement dropDownListBox=eventFiringWebDriver.findElement(By.xpath("//select[@data-widget-path='taskType_taskType']"));
	Select clickThis = new Select(dropDownListBox);
	clickThis.selectByVisibleText("Phone Call");
	eventFiringWebDriver.findElement(By.xpath("//input[@data-widget-path='dueDate']")).sendKeys("05-08-2014");
	eventFiringWebDriver.findElement(By.xpath("//textarea[@placeholder='Write a note...']")).sendKeys(dynamic_note);
	eventFiringWebDriver.findElement(By.xpath("//button[@data-action='addAttachment']")).click();
	eventFiringWebDriver.findElement(By.xpath("//textarea[@placeholder='Write a note...']")).click();
	rtab();
	Thread.sleep(500);
	rtab();
	Thread.sleep(500);
	rClick();
	//System.out.println(attachment_path);
  	Thread.sleep(5000);
  	control_L();
	Thread.sleep(1000);
	rtype(attachment_path+"test.html");	
   	Thread.sleep(1000);
	rClick();
	Thread.sleep(2000);
	save_popup_details();
	Thread.sleep(5000);
}
public void add_quote_atachment() throws InterruptedException, AWTException {
	eventFiringWebDriver.findElement(By.xpath("//label[@for='attachment']/a/img")).click();
	eventFiringWebDriver.findElement(By.xpath("//a[contains(text(),'Add an item')]")).click();
	Thread.sleep(500); 	
	eventFiringWebDriver.findElement(By.xpath("//label[@for='attachment']/a/img")).click();
  	//eventFiringWebDriver.findElement(By.xpath("//button[contains(.,'Attach File')]")).click();
   	Thread.sleep(500);
	rtab();	
  	rClick();
	System.out.println(attachment_path);
  	Thread.sleep(5000);
  	control_L();
	Thread.sleep(1000);
	rtype(attachment_path+"test.html");	
   	Thread.sleep(1000);
	rClick();
}
public void add_reseller_quote_atachment() throws InterruptedException, AWTException {
	Thread.sleep(1000); 
	eventFiringWebDriver.findElement(By.xpath("//label[@for='resellerQuote']/a/img")).click();
	Thread.sleep(1000); 
	eventFiringWebDriver.findElement(By.linkText("Add an item")).click();
	Thread.sleep(1000); 
	eventFiringWebDriver.findElement(By.xpath("//label[@for='resellerQuote']/a/img")).click();
	Thread.sleep(500);
	rtab();
	rClick();
	//eventFiringWebDriver.findElement(By.xpath("//button[contains(.,'Attach File')]")).click();
System.out.println(attachment_path);
	Thread.sleep(5000);
	control_L();
Thread.sleep(1000);
rtype(attachment_path+"test.txt");	
	Thread.sleep(1000);
rtab();
Thread.sleep(1000);
rtab();
Thread.sleep(1000);
rClick();
}
public void add_attachment_on_activity_stream(String document_name) throws InterruptedException, AWTException {
	eventFiringWebDriver.findElement(By.xpath("//textarea[@class='ROD-textarea']")).click();
	Thread.sleep(1000);
	rtab();
	Thread.sleep(500);
    rtab();
    rClick();
	Thread.sleep(3000);
	control_L();
	Thread.sleep(1000);
	rtype(attachment_path+document_name);	
   	Thread.sleep(1000);
	rClick();
  	Thread.sleep(1000);
	eventFiringWebDriver.findElement(By.xpath("//textarea[@class='ROD-textarea']")).click();
}
public WebElement post_note_button() throws InterruptedException {
	ele=eventFiringWebDriver.findElement(By.xpath("//button[contains(.,'Post')]"));
	return ele;
}
public void save_popup_details() throws InterruptedException {
	eventFiringWebDriver.findElement(By.id("saveBtn")).click();
	Thread.sleep(5000);
}
public WebElement clear_search() {
	ele=eventFiringWebDriver.findElement(By.xpath("//div[@class='VS-icon VS-icon-cancel VS-cancel-search-box']"));
	return ele;
	}
public WebElement booking_link() {
	ele=eventFiringWebDriver.findElement(By.xpath("//*[@id='menuItem' and @tabname='app.bookings']"));
	return ele;
	}

public void search_by(String val1, String val2) throws InterruptedException {
	clear_search().click();
	eventFiringWebDriver.findElement(By.xpath("//input[@class='ui-autocomplete-input']")).sendKeys(val1);
	eventFiringWebDriver.findElement(By.xpath("//input[contains(@class,'input VS-interface ui-autocomplete-input')]")).sendKeys(val2);
	Thread.sleep(1000);
	rClick();
	Thread.sleep(3000);
}
public void search_with_two_criteria(String val1, String val2,String val3, String val4) throws InterruptedException {
	clear_search().click();
	eventFiringWebDriver.findElement(By.xpath("//input[@class='ui-autocomplete-input']")).sendKeys(val1);
	eventFiringWebDriver.findElement(By.xpath("//input[contains(@class,'input VS-interface ui-autocomplete-input')]")).sendKeys(val2);
	Thread.sleep(1000);
	rClick();
	eventFiringWebDriver.findElement(By.xpath("//div[@class='VS-search-inner']/div[3]/input")).sendKeys(val3);
	eventFiringWebDriver.findElement(By.xpath("//div[@class='VS-search-inner']/div[4]/div[2]/input")).sendKeys(val4);
	Thread.sleep(1000);
	rClick();
	Thread.sleep(3000);
}
public WebElement selectQuote_tab() throws InterruptedException {
	ele=eventFiringWebDriver.findElement(By.xpath("//span[contains(.,'Quotes')]"));
	if (ele.isDisplayed())
	{
		return ele;
	}
	else
	{
		click_more_btn().click();
		Thread.sleep(4000);
		ele=eventFiringWebDriver.findElement(By.xpath("//*[@id='menuItem' and @tabname='app.quotes']"));
		return ele;	
	}	
	
}

public WebElement selectQuote_link() throws InterruptedException {
	ele=eventFiringWebDriver.findElement(By.xpath("//*[@id='menuItem' and @tabname='app.quotes']"));
	return ele;	
}

public void select_first_row() {
	eventFiringWebDriver.findElement(By.xpath("//table[@class='ui-jqgrid-btable widget-subgrid-expanded']//tr[@id='1']")).click();
	//eventFiringWebDriver.findElement(By.xpath("/html/body/div[4]/div[7]/div/div/div/div[2]/div/div[3]/div/div[3]/div[3]/div/table/tbody/tr[2]/td[2]/span")).click();
}
public void select_given_row(int i) {
	i=i+1;
	eventFiringWebDriver.findElement(By.xpath("/html/body/div[4]/div[7]/div/div/div/div[2]/div/div[3]/div/div[3]/div[3]/div/table/tbody/tr["+i+"]/td[2]/span")).click();
}
public void select_first_row_subgrid() {
	eventFiringWebDriver.findElement(By.xpath("//table[@class='ui-jqgrid-btable']//tr[@id='1']")).click();
}
public WebElement log_quote_button() {
	ele=eventFiringWebDriver.findElement(By.xpath("//button[contains(@data-actionname,'createQuote')]"));
	return ele;
}
public WebElement log_task_completion_button() {
	ele=eventFiringWebDriver.findElement(By.xpath("//button[@data-actionname='completeTask']"));
	return ele;
}
public WebElement Release_hold() {
	ele=eventFiringWebDriver.findElement(By.linkText("Release Hold"));
	return ele;
}
public WebElement Reopen_task() {
	ele=eventFiringWebDriver.findElement(By.linkText("Re-open Task"));
	return ele;
}

public void all_filter() throws InterruptedException {
clear_search();
eventFiringWebDriver.findElement(By.xpath("//div[contains(@class, 'av_filter') and text()='All']")).click();
Thread.sleep(3000);
}
public void organizations() throws InterruptedException {
clear_search();
eventFiringWebDriver.findElement(By.xpath("//div[contains(@class, 'av_filter') and text()='Organizations']")).click();
Thread.sleep(3000);
}
public void click_service_asset() throws InterruptedException {
clear_search();
eventFiringWebDriver.findElement(By.xpath("//div[contains(@class, 'av_filter') and text()='Service Assets']")).click();
Thread.sleep(3000);
}
public WebElement click_more_btn() {
	ele=eventFiringWebDriver.findElement(By.xpath("//span[contains(.,'More')]"));
	return ele;
}
public WebElement activity_tab() {
	ele=eventFiringWebDriver.findElement(By.linkText("Activity"));
	return ele;
}
public void write_a_note() {
	eventFiringWebDriver.findElement(By.xpath("//textarea[@class='ROD-textarea']")).sendKeys(dynamic_note);
}
public WebElement request_quote_button() {
  ele=eventFiringWebDriver.findElement(By.xpath("//button[@data-actionname='requestBooking']"));
  return ele;
}
public void check_elements_deletion() {
	try {
	     eventFiringWebDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		 isPresent = eventFiringWebDriver.findElements(By.xpath("//a[contains(.,'test.html')]")).size()==0;
		 eventFiringWebDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		 isPresent = eventFiringWebDriver.findElements(By.xpath("//a[contains(.,'test.txt')]")).size()==0;
		 eventFiringWebDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		} 
	catch (NoSuchElementException e) {
         System.out.println("Error in deletion");
		}
}
public void check_attachment_deleted() {
	try {
	     eventFiringWebDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		 isPresent = eventFiringWebDriver.findElements(By.xpath("//a[contains(.,'test.html')]")).size()==0;
		 eventFiringWebDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		} 
	catch (NoSuchElementException e) {
        System.out.println("Error in deletion");
		}
}
public void verify_single_attachment_deletion() throws InterruptedException {
	try {
	     eventFiringWebDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		 isPresent = eventFiringWebDriver.findElements(By.xpath("//a[contains(.,'test.html')]")).size()==0;
		 Thread.sleep(6000);
		} 
	catch (NoSuchElementException e) {
        System.out.println("Error in deletion");
		}
}
public void check_element_deletion() {
	try {
		
		eventFiringWebDriver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
		boolean exists = eventFiringWebDriver.findElements(By.xpath("//h5[@class='pretext']")).size() != 0;
		
	     //eventFiringWebDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		// isPresent = eventFiringWebDriver.findElements(By.xpath("//a[contains(.,'test.html')]")).size()==0;
		 if (exists==true)
		 {
			 note_text=eventFiringWebDriver.findElement(By.xpath("//h5[@class='pretext']")).getText();
			 assertTrue("Assert Successfull",!dynamic_note.equalsIgnoreCase(note_text));
		 }
		 else
		 { 
			 note_empty_msg=eventFiringWebDriver.findElement(By.xpath("//span[contains(.,'There is no activity to display')]")).getText();
			 assertEquals(note_empty_msg,"There is no activity to display");
		 }
		 
		 eventFiringWebDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		} 
	catch (NoSuchElementException e) {
         System.out.println("Error in deletion"+e.getMessage());
	}
}

public void delete_note_attachment_activity_stream() throws InterruptedException {
    Thread.sleep(1000);
	eventFiringWebDriver.findElement(By.cssSelector("button.ROD-trash-btn")).click();
	Thread.sleep(4000);
}

public void delete_attachment_activity_on_stream() throws InterruptedException {
    Thread.sleep(1000);
	eventFiringWebDriver.findElement(By.cssSelector("button.ROD-trash-btn")).click();
	Thread.sleep(4000);
}

public WebElement note_text_on_activity(){
	ele=eventFiringWebDriver.findElement(By.xpath("//h5[@class='pretext']"));
	return ele;
}
public void verify_note_with_attachment_uploaded() {
	note_text=note_text_on_activity().getText();
	attachment_name1=eventFiringWebDriver.findElement(By.xpath("//a[contains(.,'test.html')]")).getText();
	assertEquals("test.html", attachment_name1);
	assertEquals(dynamic_note,note_text);
}
public void fill_request_booking_popup_with_multiple_attachments() throws InterruptedException, AWTException{
	eventFiringWebDriver.findElement(By.xpath("//input[@data-modelattr='poNumber']")).sendKeys("1234");
	eventFiringWebDriver.findElement(By.xpath("//input[@data-widget-path='poDate']")).sendKeys("04-10-2014");
	eventFiringWebDriver.findElement(By.xpath("//input[@data-widget-path='poAmount_amount']")).sendKeys("4500");;
	WebElement dropDownListBox = eventFiringWebDriver.findElement(By.xpath("//select[@data-widget-path='winResultReason_winResultReason']"));
	Select clickThis = new Select(dropDownListBox);
	clickThis.selectByVisibleText("CS - Backdated - BKD");
	eventFiringWebDriver.findElement(By.xpath("//img[@src='images/widget/duplo.form2/arrow_sm_down_black.png']")).click();
	eventFiringWebDriver.findElement(By.linkText("Add an item")).click();
	Thread.sleep(500);
	eventFiringWebDriver.findElement(By.xpath("//img[@src='images/widget/duplo.form2/arrow_sm_down_black.png']")).click();
	Thread.sleep(500);
	rtab();
	Thread.sleep(500);
	rClick();
	Thread.sleep(3000);
	control_L();
	Thread.sleep(1000);
	rtype(attachment_path+"test.txt");	
   	Thread.sleep(1000);
	rClick();
   	Thread.sleep(1000);
	eventFiringWebDriver.findElement(By.xpath("//img[@src='images/widget/duplo.form2/arrow_sm_down_black.png']")).click();
	Thread.sleep(1000);
	//eventFiringWebDriver.findElement(By.xpath("//a[contains(text(),'Add an item')]")).click();
	eventFiringWebDriver.findElement(By.linkText("Add an item")).click();
	Thread.sleep(500);
	eventFiringWebDriver.findElement(By.xpath("//img[@src='images/widget/duplo.form2/arrow_sm_down_black.png']")).click();
	Thread.sleep(500);
	rtab();
	Thread.sleep(500);
	rtab();
	Thread.sleep(500);
	rtab();
	Thread.sleep(500);
	rClick();
	Thread.sleep(3000);
	control_L();
	Thread.sleep(1000);
	rtype(attachment_path+"test.html");	
   	Thread.sleep(1000);
	rClick();
	save_popup_details();
	Thread.sleep(3000);
	}
protected void select_from_listbox(WebElement locator,String Text) {
	WebElement dropDownListBox = locator;
	Select clickThis = new Select(dropDownListBox);
	clickThis.selectByVisibleText(Text);
}
public void get_first_opportunity_name() {
	opp_name=eventFiringWebDriver.findElement(By.xpath("//table[@class='ui-jqgrid-btable widget-subgrid-expanded']//tr[@id='1']")).getText();
}
public void fill_complete_booking_popup() throws InterruptedException, AWTException {
	eventFiringWebDriver.findElement(By.xpath("//input[@data-widget-path='create_quoteNumber']")).sendKeys("sample quote");
	Quote_name=eventFiringWebDriver.findElement(By.xpath("//div[@data-bind='text displayName']")).getText();
	eventFiringWebDriver.findElement(By.xpath("//input[@data-widget-path='completeBooking_poAmount_amount']")).clear();
	eventFiringWebDriver.findElement(By.xpath("//input[@data-widget-path='completeBooking_poAmount_amount']")).sendKeys("45");
	WebElement dropDownListBox = eventFiringWebDriver.findElement(By.xpath("//select[@data-widget-path='completeBooking_poAmount_code_code']"));
	Select clickThis = new Select(dropDownListBox);
	clickThis.selectByVisibleText("USD");
	eventFiringWebDriver.findElement(By.xpath("//input[@data-widget-path='completeBooking_poDate']")).sendKeys(current_date());
	Thread.sleep(2000);
	eventFiringWebDriver.findElement(By.xpath("//input[@data-widget-path='completeBooking_soNumber']")).sendKeys("8523");
	WebElement dropDownListBox1 = eventFiringWebDriver.findElement(By.xpath("//select[@data-widget-path='request_requestReason_requestReason']"));
	Select clickThis1 = new Select(dropDownListBox1);
	clickThis1.selectByVisibleText("Initial Quote");
	eventFiringWebDriver.findElement(By.xpath("//input[@data-widget-path='completeBooking_soAmount_amount']")).clear();
	eventFiringWebDriver.findElement(By.xpath("//input[@data-widget-path='completeBooking_soAmount_amount']")).sendKeys("45");
	WebElement dropDownListBox2 = eventFiringWebDriver.findElement(By.xpath("//select[@data-widget-path='completeBooking_soAmount_code_code']"));
	Select clickThis2 = new Select(dropDownListBox2);
	clickThis2.selectByVisibleText("USD");
	eventFiringWebDriver.findElement(By.xpath("//input[@data-widget-path='completeBooking_soDate']")).sendKeys(current_date());
	Thread.sleep(2000);
	eventFiringWebDriver.findElement(By.xpath("//input[@data-widget-path='create_quoteNumber']")).sendKeys("1234");
	eventFiringWebDriver.findElement(By.xpath("//input[@data-widget-path='completeBooking_poNumber']")).sendKeys("500");
	WebElement dropDownListBox3 = eventFiringWebDriver.findElement(By.xpath("//select[@data-widget-path='completeBooking_winResultReason_winResultReason']"));
	Select clickThis3 = new Select(dropDownListBox3);
	clickThis3.selectByVisibleText("CS - Backdated - BKD");
	//Quote_name=eventFiringWebDriver.findElement(By.xpath("//input[@data-widget-path='request_displayName']")).getText();
	System.out.println(Quote_name);
	
	//for attachment
	eventFiringWebDriver.findElement(By.xpath("//label[@for='attachment']/a/img")).click();
	eventFiringWebDriver.findElement(By.linkText("Add an item")).click();
	eventFiringWebDriver.findElement(By.xpath("//label[@for='attachment']/a/img")).click();
	Thread.sleep(500);
	rtab();
	Thread.sleep(500);
	rClick();
	rtab();	
  	rClick();
	System.out.println(attachment_path);
  	Thread.sleep(5000);
  	control_L();
	Thread.sleep(1000);
	rtype(attachment_path+"test.html");	
   	Thread.sleep(1000);
	rClick();
	Thread.sleep(2000);
	eventFiringWebDriver.findElement(By.xpath("//label[@for='resellerQuote']/a/img")).click();
	eventFiringWebDriver.findElement(By.linkText("Add an item")).click();
	eventFiringWebDriver.findElement(By.xpath("//label[@for='resellerQuote']/a/img")).click();
	Thread.sleep(500);
	rtab();
	Thread.sleep(500);
	rClick();
	rtab();	
  	rClick();
	System.out.println(attachment_path);
  	Thread.sleep(5000);
  	control_L();
	Thread.sleep(1000);
	rtype(attachment_path+"test.txt");	
   	Thread.sleep(1000);
	rClick();
	Thread.sleep(2000);
	save_popup_details();
	Thread.sleep(5000);
}
public void quote_reseller_quote_attachment() throws InterruptedException, AWTException {
	eventFiringWebDriver.findElement(By.xpath("//label[@for='attachment']/a/img")).click();
	eventFiringWebDriver.findElement(By.linkText("Add an item")).click();
	eventFiringWebDriver.findElement(By.xpath("//label[@for='attachment']/a/img")).click();
	Thread.sleep(500);
	rtab();
	Thread.sleep(500);
    rtab();
    rClick();
	Thread.sleep(3000);
	control_L();
	Thread.sleep(1000);
	rtype(attachment_path+"test.html");	
   	Thread.sleep(1000);
	rClick();
  	Thread.sleep(1000);
	eventFiringWebDriver.findElement(By.xpath("//label[@for='resellerQuote']/a/img")).click();
	eventFiringWebDriver.findElement(By.linkText("Add an item")).click();
	eventFiringWebDriver.findElement(By.xpath("//label[@for='resellerQuote']/a/img")).click();
	Thread.sleep(500);
	rtab();
	Thread.sleep(500);
    rtab();
    rClick();
	Thread.sleep(3000);
	control_L();
	Thread.sleep(1000);
	rtype(attachment_path+"test.txt");	
   	Thread.sleep(1000);
	rClick();
  	Thread.sleep(1000);
}
public void select_given_data(String expression) throws InterruptedException {
	switch(expression){
    case "opportunity" :
    	selectOpportunity_tab().click();
        all_filter();
    	Thread.sleep(1000);
    	select_first_row();
       break; //optional
    case "booking" :
       selectBooking_tab().click();
       all_filter();
   	   Thread.sleep(1000);
   	select_first_row_subgrid();
       break; //optional
    case "quote" :
    	 selectQuote_tab().click();
    	 all_filter();
     	 Thread.sleep(1000);
     	select_first_row_subgrid();
        break; //optional
    case "asset" :
   	    selectAssets_tab().click();
   	    click_service_asset();
       	Thread.sleep(1000);
       	select_first_row_subgrid();
        break; //optional
    case "contact" :
        selectContacts_tab().click();
        organizations();
    	Thread.sleep(1000);
    	select_first_row_subgrid();
        break; //optional
    case "task" :
        selectTasks_tab().click();
        all_filter();
       	Thread.sleep(1000);
       	select_first_row_subgrid();
        break; //optional
    //You can have any number of case statements.
    default : 
    	new WebDriverException("Unable to open diven tab");
    	break;
  }
}
public void post_a_note_attachment_on_activity_stream(String expression) throws InterruptedException, AWTException {
if (expression.equalsIgnoreCase("opportunity"))
	 {
	eventFiringWebDriver.findElement(By.xpath("//h2[contains(.,'Activity')]")).click();
	Thread.sleep(1000);
	add_attachment_on_activity_stream("test.html");
	Thread.sleep(2000);
	write_a_note();
	post_note_button().click();
	Thread.sleep(4000);
	 }
else
	{
	activity_tab().click();
	add_attachment_on_activity_stream("test.html");
	write_a_note();
	post_note_button().click();
	Thread.sleep(4000);
	}
}

public void post_multiple_attachments_on_activity_stream(String expression) throws InterruptedException, AWTException {
	if (expression.equalsIgnoreCase("opportunity"))
	 {
	eventFiringWebDriver.findElement(By.xpath("//h2[contains(.,'Activity')]")).click();
		add_attachment_on_activity_stream("test.html");
		add_attachment_on_activity_stream("test.txt");
		add_attachment_on_activity_stream("test.docx");
		Thread.sleep(3000);
	    post_note_button().click();
	 }
else
	{
	activity_tab().click();
	add_attachment_on_activity_stream("test.html");
	add_attachment_on_activity_stream("test.txt");
	add_attachment_on_activity_stream("test.docx");
    post_note_button().click();
	}
}
public WebElement selectOpportunity_tab() {
	ele=eventFiringWebDriver.findElement(By.xpath("//span[contains(.,'Opportunities')]"));
	return ele;
}
public WebElement selectBookingQuoteTab() {
	ele=eventFiringWebDriver.findElement(By.xpath("//h2[contains(.,'Quotes & Bookings')]"));
	return ele;
}
public WebElement select_quotes_subtab() {
	ele=eventFiringWebDriver.findElement(By.linkText("Quotes"));
	return ele;
}
public WebElement selectBooking_tab() {
	ele=eventFiringWebDriver.findElement(By.xpath("//span[contains(.,'Bookings')]"));
	return ele;
}
public WebElement selectAssets_tab() {
	ele=eventFiringWebDriver.findElement(By.xpath("//span[contains(.,'Assets')]"));
	return ele;
}
public WebElement selectContacts_tab() {
	ele=eventFiringWebDriver.findElement(By.xpath("//span[contains(.,'Contacts')]"));
	return ele;
}
public WebElement selectTasks_tab() {
	ele=eventFiringWebDriver.findElement(By.xpath("//span[contains(.,'Tasks')]"));
	return ele;
}
public WebElement more_action_button() {
	ele=eventFiringWebDriver.findElement(By.xpath("//button[@id='moreActionsBtn']"));
	return ele;
}
public WebElement complete_booking_link() {
	ele=eventFiringWebDriver.findElement(By.linkText("Complete Booking"));
	return ele;
}
public WebElement place_task_on_hold() {
	ele=eventFiringWebDriver.findElement(By.linkText("Place Task on Hold"));
	return ele;
}
public WebElement close_task_unsuccessfully() {
	ele=eventFiringWebDriver.findElement(By.linkText("Close Task Unsuccessfully"));
	return ele;
}
public void fill_close_task_unsuccessfully_popup_with_attachment(String reason) throws InterruptedException, AWTException {
	WebElement dropDownListBox=eventFiringWebDriver.findElement(By.xpath("//select[@data-widget-path='closeUnsuccessfullyReason_closeUnsuccessfullyReason']"));
	Select clickThis = new Select(dropDownListBox);
	clickThis.selectByVisibleText(reason);
	eventFiringWebDriver.findElement(By.xpath("//textarea[@data-widget-path='text']")).sendKeys(dynamic_note);
	eventFiringWebDriver.findElement(By.xpath("//button[@data-action='addAttachment']")).click();
	eventFiringWebDriver.findElement(By.xpath("//textarea[@data-widget-path='text']")).click();
	rtab();
	Thread.sleep(500);
    rtab();
    rClick();
	Thread.sleep(3000);
	control_L();
	Thread.sleep(1000);
	rtype(attachment_path+"test.html");	
   	Thread.sleep(1000);
	rClick();
	Thread.sleep(2000);
	save_popup_details();
	Thread.sleep(5000);
}
public void fill_place_task_on_hold_popup_with_attachment(String reason) throws InterruptedException, AWTException{
	WebElement dropDownListBox=eventFiringWebDriver.findElement(By.xpath("//select[@data-widget-path='holdReason_holdReason']"));
	Select clickThis = new Select(dropDownListBox);
	clickThis.selectByVisibleText(reason);
	eventFiringWebDriver.findElement(By.xpath("//textarea[@data-widget-path='text']")).sendKeys(dynamic_note);
	eventFiringWebDriver.findElement(By.xpath("//button[@data-action='addAttachment']")).click();
	eventFiringWebDriver.findElement(By.xpath("//textarea[@data-widget-path='text']")).click();
	rtab();
	Thread.sleep(500);
    rtab();
    rClick();
	Thread.sleep(3000);
	control_L();
	Thread.sleep(1000);
	rtype(attachment_path+"test.html");	
   	Thread.sleep(1000);
	rClick();
	Thread.sleep(2000);
	save_popup_details();
	Thread.sleep(5000);
}
public String get_financial_year(){
	String line_text=driver.findElement(By.xpath("//div[@class='line1']")).getText();
	return line_text.substring(0,line_text.indexOf('|'));
} 

/*public void login_application(String username,String pwd){
	   System.setProperty("webeventFiringWebDriver.firefox.bin","C:\\Users\\amans.jain\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
	   FirefoxProfile firefoxProfile = new FirefoxProfile();
	   eventFiringWebDriver = new FirefoxDriver(firefoxProfile);
	   eventFiringWebDriver = new FirefoxDriver();	  
	   eventFiringWebDriver.manage().window().maximize();
	   eventFiringWebDriver.get("https://qa3.ssi-cloud.com");
	   WebElement myDynamicElement = null;
       myDynamicElement = (new WebDriverWait(eventFiringWebDriver, 200)).until(ExpectedConditions.presenceOfElementLocated(By.id("userid")));
       eventFiringWebDriver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
       eventFiringWebDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
       eventFiringWebDriver.findElement(By.xpath("//input[@name='userid']")).sendKeys(username);
	   eventFiringWebDriver.findElement(By.id("password")).sendKeys(pwd);
	   eventFiringWebDriver.findElement(By.id("xsubmit")).click();
}*/

}

