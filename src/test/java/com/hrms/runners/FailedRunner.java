package com.hrms.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="@target/failed.txt"
		,glue="com/hrms/steps"
//		,dryRun=false          // find unimplemented if it is true before executed false show after executed
//		,plugin= {"pretty", "html:target/html/cucumber-default-report"}
		,monochrome=true  
//		,tags= {"@regression"}
		)


public class FailedRunner {

}
