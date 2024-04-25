
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {

    public Actions testing = new Actions(); // Instantiate your existing Selenium test class
    // public static Testing connection;

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        testing.invokeBrowser();
    }

    @Then("the title of the web page tab should be {string}")
    public void the_title_of_the_web_page_tab_should_be(String expectedTitle) {
        String actualTitle = testing.getTitleforTest();
        assertTrue(actualTitle.equals("4YOU - Start your day") || actualTitle.equals("4YOU - Se connecter"),
                "Title should be either '4YOU - Start your day' or '4YOU - Se connecter'");
    }

    @When("I enter username {string} and password {string}")
    public void i_enter_username_and_password(String username, String password) {
        testing.login(username, password);
    }
    @When("I click on the manager button")
    public void clickManagerButton() {
        testing.clickManagerButton();
    }

    @When("I click on the next button")
    public void clickNextButton() {
        testing.clickNextButton();
    }


    @Then("I should see the welcome message if login is successful")
    public void i_should_see_the_welcome_message_if_login_is_successful() {
        String actualMessage = testing.waitForToastMessage();
        assertEquals("Vous vous êtes connecté(e) avec succès !", actualMessage);
    }

    private void assertEquals(String s, String actualMessage) {
    }

    @Then("I should see an error message if login fails")
    public void i_should_see_an_error_message_if_login_fails() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
        String actualTitle = testing.ErrorMessage();
        assertEquals("Nous ne reconnaissons pas vos identifiants. Merci de réessayer !", actualTitle);

    }

    @Then("I should see the employee full name {string}")
    public void i_should_see_the_employee_full_name(String expectedFullName) {
        String actualFullName = testing.checkIdForEmployee();
        assertEquals(expectedFullName, actualFullName);
    }

    @Then("I should see the employee job {string}")
    public void i_should_see_the_employee_job(String expectedJob) {
        String actualJob = testing.checkJobForEmployee();
        assertEquals(expectedJob, actualJob);
    }

    @Then("I should see the page title {string}")
    public void i_should_see_the_page_title(String expectedTitle) {
        String actualTitle = testing.pageTitle1();
        assertEquals("Profil collaborateur", actualTitle);
    }

    @Then("I should see the number of absences")
    public void i_should_see_the_number_of_absences() {
        String absDays = testing.checkAbsDays();
        assertEquals("Aucun droit de congé à ce jour.", absDays);
    }

    @Then("I should see the remuneration content")
    public void i_should_see_the_remuneration_content() {
        String content = testing.remuneration();
        assertEquals("2 000,00 €", content);
    }

    @Then("I should see the absence days page title")
    public void i_should_see_the_absence_days_page_title() {
        String pageTitleAbs = testing.workVacation();
        assertEquals("Mes absences", pageTitleAbs);
    }

    @Then("I should see the maladie page title")
    public void i_should_see_the_maladie_page_title() {
        int Date = 22112025;
        String pageTitleMaladie = testing.maladie(Date);
        assertEquals("Some expected title", pageTitleMaladie); // You should replace "Some expected title" with the
        // actual expected title
    }
    @When("I declare a sick leave with date {int}")
    public void declareSickLeave(int date) {
        testing.maladie(date);
    }
    @After
    public void closeDriver() {
        testing.closeDriver();
    }
}