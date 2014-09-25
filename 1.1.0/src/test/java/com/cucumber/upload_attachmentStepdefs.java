package com.cucumber;

import cucumber.api.Transformer;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Locatorsandmethods;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class upload_attachmentStepdefs extends Locatorsandmethods {
 //public	WebDriver eventFiringWebDriver=null; 
	   
//	@Given("^I am login a Sales Ops Rep$")
//	    public void login() throws InterruptedException, IOException {
//			  login_application("ryan.thompson","passwordone");		       	
//		}
//	
    
    @When("^I fill log quote complete popup with attachment$")
    public void fill_quote() throws InterruptedException, AWTException {
    	log_quote_button().click();
    	fill_quote_popup();
      	add_quote_atachment();
      	add_reseller_quote_atachment();
      	Thread.sleep(3000);
      	save_popup_details();
	    Thread.sleep(2000);
    } 
    
  
@Then("^I should verify attached fields$")
    public void verify_fields() {
		attachment_name1=eventFiringWebDriver.findElement(By.xpath("//a[contains(.,'test.html')]")).getText();
		assertEquals("test.html", attachment_name1);
		attachment_name2=eventFiringWebDriver.findElement(By.xpath("//a[contains(.,'test.txt')]")).getText();
		assertEquals("test.txt", attachment_name2);
	}

@Given("^I select opportunity status as \"(.*?)\"$")
public void i_select_opportunity_status_as(String arg1) throws Throwable {
	selectOpportunity_tab().click();
	search_with_two_criteria("SALES-STAGE:",arg1,"SELLING-PERIOD:","FY15Q3");
	//search_with_two_criteria("SALES-STAGE:",arg1,"SELLING-PERIOD:",get_financial_year());
	//search_by("SALES-STAGE:",arg1);
	Thread.sleep(1000);
	select_first_row();
}

@And("^I select complete booking option$")
public void i_select_complete_booking_option() throws InterruptedException {
	Thread.sleep(6000);
	more_action_button().click();
	complete_booking_link().click();
	Thread.sleep(6000);
}
	
@When("^I fill complete booking popup with quote and reseller attachment$")
public void i_fill_complete_booking_popup_with_quote_and_reseller_attachment() throws Throwable {
	fill_complete_booking_popup();
}
@Then("^I should see attachment on opportunity details quotes subtab$")
public void i_should_see_attachment_on_opportunity_details_quotes_subtab() throws Throwable {
	Thread.sleep(3000);
	eventFiringWebDriver.findElement(By.xpath("//h2[contains(.,'Quotes & Bookings')]")).click();
	Thread.sleep(2000);
	select_first_row_subgrid();
	Thread.sleep(2000);
	attachment_name1=eventFiringWebDriver.findElement(By.xpath("//a[contains(.,'test.html')]")).getText();
	assertEquals("test.html", attachment_name1);
	attachment_name2=eventFiringWebDriver.findElement(By.xpath("//a[contains(.,'test.txt')]")).getText();
	assertEquals("test.txt", attachment_name2);
}

@And("^I select a quote$")
public void i_select_a_quote() throws InterruptedException {
	click_more_btn().click();
	Thread.sleep(4000);
	selectQuote_link().click();
	all_filter();
	select_first_row_subgrid();
}
@When("^I add note with attachment$")
public void i_add_note_with_attachment() throws InterruptedException, AWTException {
	activity_tab().click();
	write_a_note();
    add_attachment_on_activity_stream("test.html");
    Thread.sleep(4000);
	post_note_button().click();
	Thread.sleep(3000);
}
@And("^I select a booking$")
public void i_select_a_booking() throws InterruptedException{
	click_more_btn().click();
	Thread.sleep(4000);
	booking_link().click();
	all_filter();
	Thread.sleep(4000);
	select_first_row_subgrid();
}
@And("^I select a quote with status as delivered$")
public void i_select_a_quote_with_status_as_delivered() throws InterruptedException {
	selectOpportunity_tab().click();
	search_with_two_criteria("SALES-STAGE:", "Quote Delivered","AMOUNT:",">0");
	select_first_row();
	Thread.sleep(2000);
	selectBookingQuoteTab().click();
	select_quotes_subtab().click();
	Thread.sleep(2000);	
	select_first_row_subgrid();
	Thread.sleep(2000);
	//select_given_row(2);
}
@When("^I fill request booking popup with multiple attachments$")
public void i_fill_request_booking_popup_with_multiple_attacments() throws InterruptedException, AWTException{
	request_quote_button().click();
	Thread.sleep(3000);
	fill_request_booking_popup_with_multiple_attachments();
}
@Then("^I should see the (\\d+) attachments under purchase order field$")
public void i_should_see_the_attachments_under_purchase_order_field(int arg1) throws InterruptedException {
	eventFiringWebDriver.findElement(By.xpath("//a[@rel='booking']")).click();
	Thread.sleep(4000);
	attachment_name1=eventFiringWebDriver.findElement(By.xpath("//a[contains(.,'test.html')]")).getText();
	assertEquals("test.html", attachment_name1);
	attachment_name2=eventFiringWebDriver.findElement(By.xpath("//a[contains(.,'test.txt')]")).getText();
	assertEquals("test.txt", attachment_name2);
    Thread.sleep(4000);
}
@Then("^I should verify note with attachment$")
public void i_should_verify_note_with_attachment() {
	verify_note_with_attachment_uploaded();
}

@And("^I select a \"(.*?)\"$")
public void i_select_a(String arg1) throws Throwable {
	select_given_data(arg1);
}
@When("^I post a note with attachment on activity stream on \"(.*?)\" details page$")
public void i_post_a_note_with_attachment_on_activity_stream_on_details_page(String arg1) throws Throwable {
   post_a_note_attachment_on_activity_stream(arg1);
}
@Then("^I should verify note with attachment on activity stream$")
public void i_should_verify_note_with_attachment_onactivity_stream() {
	verify_note_with_attachment_uploaded();
}
@When("^I delete note with attachment on activity stream$")
public void i_delete_note_with_attachment_on_activity_stream() throws Throwable {
  delete_note_attachment_activity_stream();
}
@Then("^I should not see attached note and file$")
public void i_should_not_see_attached_note_and_file() throws Throwable {
	check_element_deletion();
}
@When("^I post multiple attachments on activity stream on \"(.*?)\" details page$")
public void i_post_multiple_attachments_on_activity_stream_on_details_page(String arg1) throws Throwable {
	post_multiple_attachments_on_activity_stream(arg1);
}
@Then("^I should all see attached files are included in the new activity record$")
public void i_should_see_attached_files_are_included_in_the_new_activity_record() throws Throwable {
	attachment_name1=eventFiringWebDriver.findElement(By.xpath("//a[contains(.,'test.html')]")).getText();
	assertEquals("test.html", attachment_name1);
	attachment_name2=eventFiringWebDriver.findElement(By.xpath("//a[contains(.,'test.txt')]")).getText();
	assertEquals("test.txt", attachment_name2);
	attachment_name1=eventFiringWebDriver.findElement(By.xpath("//a[contains(.,'test.docx')]")).getText();
	assertEquals("test.docx", attachment_name1);
	Thread.sleep(3000);
}
@When("^I delete one attachment of recently posted activity$")
public void i_delete_one_attachment_of_recently_posted_activity() throws Throwable {
	eventFiringWebDriver.findElement(By.xpath("//ul[@class='activity-stream-list']/li[2]/div/div[1]/button")).click();
    Thread.sleep(1000);
}
@Then("^I should see all uploaded files except deleted one$")
public void i_should_see_all_uploaded_files_except_deleted_one() throws Throwable {
	attachment_name2=eventFiringWebDriver.findElement(By.xpath("//a[contains(.,'test.txt')]")).getText();
	assertEquals("test.txt", attachment_name2);
	attachment_name1=eventFiringWebDriver.findElement(By.xpath("//a[contains(.,'test.docx')]")).getText();
	assertEquals("test.docx", attachment_name1);
	eventFiringWebDriver.findElement(By.xpath("//ul[@class='activity-stream-list']/li[2]/div/div[1]")).click();
	Thread.sleep(1000);
	attachment_name1=eventFiringWebDriver.findElement(By.xpath("//ul[@class='activity-stream-list']/li[2]/div/div[1]")).getText();
	assertTrue("Error in Deletion",!attachment_name1.equalsIgnoreCase("test.html"));
	Thread.sleep(3000);
 }

@When("^I create a task with attachment$")
public void i_create_a_task_with_attachment() throws Throwable {
	   selectTasks_tab().click();
	   new_button().click();
	   Thread.sleep(3000);
	   create_task_popup_with_attachment();
}

@Then("^I should verify activity with note and attachment$")
public void i_should_verify_activity_with_note_and_attachment() throws Throwable {
	selectTasks_tab().click();;
	search_by("NAME:",task_name);
	select_first_row_subgrid();
	activity_tab().click();
	verify_note_with_attachment_uploaded();
	}

@Then("^I verify attachment deleted from activity$")
public void i_verify_attachment_deleted_from_activity() throws Throwable {
	 verify_single_attachment_deletion();
}

@Given("^I selected a task with status:\"(.*?)\"$")
public void i_selected_a_task_with_status(String arg1) throws Throwable {
	selectTasks_tab().click();;
	search_by("STATUS:",arg1);
	select_first_row_subgrid();
	Thread.sleep(5000);
}

@When("^I fill task placed on hold popup with attachment$")
public void i_fill_task_placed_on_hold_popup_with_attachment() throws Throwable {
	more_action_button().click();
	place_task_on_hold().click();
	fill_place_task_on_hold_popup_with_attachment("Review");
}

@Then("^I verify activity with message \"(.*?)\"$")
public void i_verify_activity_with_message(String arg1) throws Throwable {
	activity_tab().click();
	name=eventFiringWebDriver.findElement(By.xpath("//h4[contains(.,'"+ arg1 +"')]")).getText();
	assertTrue("Assertion True", name.contains(arg1));
}

@When("^I fill close task - unsuccessfully popup with attachment$")
public void i_fill__close_task_unsuccessfully_popup_with_attachment() throws Throwable {
	more_action_button().click();;
	close_task_unsuccessfully().click();
	fill_close_task_unsuccessfully_popup_with_attachment("Other");
}

@When("^I select log quote complete$")
public void i_select_log_quote_complete() throws Throwable {
	log_task_completion_button().click();
}
@When("^I select Release Hold$")
public void i_select_release_hold() throws Throwable {
	more_action_button().click();
	Release_hold().click();
}
@When("^I select Re-open Task$")
public void i_select_reopen_task() throws Throwable {
	more_action_button().click();
	Reopen_task().click();
}

@And("^I select a quote with status as requested$")
public void i_select_a_quote_with_status_as_requested() throws Throwable {
  selectQuote_tab().click();
  search_by("STATUS:","Requested");
  Thread.sleep(2000);
  select_first_row_subgrid();
}
@When("^I attach attachment under quote and reseller quote$")
public void i_attach_attachment_under_quote_and_reseller_quote() throws Throwable {
	quote_reseller_quote_attachment();
}

@Then("^I should see attached files$")
public void i_should_see_attached_files() throws Throwable {
 	attachment_name1=eventFiringWebDriver.findElement(By.xpath("//a[contains(.,'test.html')]")).getText();
	assertEquals("test.html", attachment_name1);
	attachment_name2=eventFiringWebDriver.findElement(By.xpath("//a[contains(.,'test.txt')]")).getText();
	assertEquals("test.txt", attachment_name2);
}

@When("^I delete attachment under quote and reseller quote$")
public void i_delete_attachment_under_quote_and_reseller_quote() throws Throwable {
    eventFiringWebDriver.findElement(By.cssSelector("button.widget-trash-btn")).click();
    Thread.sleep(1000);
    eventFiringWebDriver.findElement(By.cssSelector("button.widget-trash-btn")).click();
}
@Then("^I should not see attached files$")
public void i_should_not_see_attached_files() throws Throwable {
	check_elements_deletion();	
}

//**************************************************Extra Business Scenarios Step Defs that not found above*****************************************************//

@When("^I delete attachment$")
public void i_delete_attachment() throws Throwable {
	eventFiringWebDriver.findElement(By.xpath("//ul[@class='activity-stream-list']/li[2]/div/div[1]/button")).click();
    Thread.sleep(2000);
}

@Then("^I should verify attachment deleted$")
public void i_should_verify_attachment_deleted() throws Throwable {
	check_attachment_deleted();
}

@When("^I deleted note$")
public void i_deleted_note() throws Throwable {
	delete_note_attachment_activity_stream();
}

@Then("^I should verify note deleted$")
public void i_should_verify_note_deleted() throws Throwable {
	check_element_deletion();
}

}


	
