package uk.co.testcraft.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import gherkin.ast.Feature;
import gherkin.ast.Scenario;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        plugin = {"pretty", "html:target/cucumber"},
        glue = {"uk.co.testcraft.stepDefs"})
public class RunCukesTest {

    }

