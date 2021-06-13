package org.bankaccount.acceptance;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions( features = "src/test/resources/org/bankaccount", monochrome = true,
        plugin = {"pretty", "html:target/site/cucumber"})
public class AcceptanceTest {

}
