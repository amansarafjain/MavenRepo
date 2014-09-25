package com.cucumber;

import java.io.IOException;

import cucumber.api.java.en.Given;

public class LoginStepFile extends com.constants.login {
	
	@Given("^I am login a Sales Ops Rep$")
    public void login() throws InterruptedException, IOException {
		  login_application("ryan.thompson","passwordone");		       	
	}
	@Given("^I am login as a Data Analyst$")
	public void i_am_login_as_a_Data_Analyst() throws Throwable {
		login_application("bill.moor","passwordone"); 
	}
	@Given("^I am login a inside sales rep$")
	public void i_am_login_a_inside_sales_rep()  {
		 login_application("jerry.lee","passwordone");
	}
	@Given("^I am login a sales ops AM$")
	public void i_am_login_as_a_sales_AM()  {
		 login_application("erin.hagens","passwordone");
	}

}
