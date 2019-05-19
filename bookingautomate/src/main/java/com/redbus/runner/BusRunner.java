package com.redbus.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;




@RunWith(Cucumber.class)
@CucumberOptions(features = "C:/Dell/Work/bookingautomate/src/main/java/features/BusVerify.feature",
glue="com/qa/stepDefinations",
tags=("@bus"),
monochrome=true,
strict=true,
dryRun=false)

public class BusRunner {

}
