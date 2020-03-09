package com.hrms.steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import utils.CommonMethods;

public class Hooks extends CommonMethods {

	@Before
	public void start(Scenario scenario) {
		System.out.println("Starting scenario "+scenario.getName());
		setUp();
		initializeAllPage();
	}
	
	@After
	public void end(Scenario scenario) {
		System.out.println("Ending scenario "+scenario.getName());
		if(scenario.isFailed()) {
		byte[] picture = takeScreenshot("/failed/"+scenario.getName());
		scenario.embed(picture, "image/png");
		}else {
		byte[] picture=	takeScreenshot("/passed/"+scenario.getName());
		scenario.embed(picture, "image/png");
		}
		tearDown();
	}
}
