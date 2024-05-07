package com.example.action;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Actions{

    static WebDriver driver;

    public void invokeBrowser() {
        // Make sure to update the location of the chromedriver.exe file
        System.setProperty("webdriver.chrome.driver", "C:/Users/aboussarsar/Desktop/edge/chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://foryou-hra-7-2-hotfix.apps.shr-okd.marc.fr.ssg/app/foryou/index.html#/sydexpert");
        // driver.manage().window().maximize();

    }

    public void login(String username, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement loginInput = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='loginInput']")));
        loginInput.sendKeys(username);

        WebElement passwordInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("passwordInput")));
        passwordInput.sendKeys(password);

        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("loginButton")));
        loginButton.click();
    }



    public void getTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.or(ExpectedConditions.titleContains("4YOU - Se connecter"),
                ExpectedConditions.titleContains("4YOU - Start your day")));
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
    }

    public String getTitleforTest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.or(ExpectedConditions.titleContains("4YOU - Se connecter"),
                ExpectedConditions.titleContains("4YOU - Start your day")));
        return driver.getTitle();
    }

    //manager
    public void closeDriver() {
        driver.close();
    }

    public void getWelcomMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        WebElement WelcMessg = driver
                .findElement(By.xpath("//div[@id='toast-container']//div[@class='toast-message'][contains(text()"));
        String message = WelcMessg.getText();
        System.out.println(message);
    }
    public String ErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement ErrorMsg = driver.findElement(By.xpath("//p[@id='errorMsg']"));
        String message = ErrorMsg.getText();

        return message ;
    }
    public String waitForToastMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement WelcMessg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//div[@id='toast-container']//div[@class='toast-message'][contains(text(),'Vous vous êtes connecté(e) avec succès !')]")));
        String message = driver.findElement(By.xpath(
                        "//div[@id='toast-container']//div[@class='toast-message'][contains(text(),'Vous vous êtes connecté(e) avec succès !')]"))
                .getText();
        return message;

    }
    public void clickManagerButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement managerButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("manager")));

        managerButton.click();
    }

    public void clickNextButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("fromSydToPc")));

        nextButton.click();
    }
    public static String checkIdForEmployee() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement managerButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("manager")));
        managerButton.click();

        WebElement fullNameElement = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='person-name']")));
        return fullNameElement.getText();
    }

    public static String checkJobForEmployee() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement jobElement = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='job']")));
        return jobElement.getText();
    }

    public String checkAbsDays() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement AbsAvailable = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//span[@data-i18n='folder_manager_leaves_forbid']")));
        return AbsAvailable.getText();

    }

    public String pageTitle1() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("fromSydToPc")));
        nextButton.click();
        WebElement pgTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pageTitle")));

        return pgTitle.getText();

    }

    public String workVacation() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement numAbs = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='submit-leave modifiable']")));
        numAbs.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        WebElement month_mai = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='ui-id-3']")));
        month_mai.click();
        WebElement firstDay = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@id='firstHalfDayClass-2024-05-02']")));
        firstDay.click();
        // driver.findElement(By.xpath("//td[@id='firstHalfDayClass-2024-05-02']")).click();
        driver.findElement(By.xpath("//td[@id='lastHalfDayClass-2024-05-02']")).click();
        driver.findElement(By.xpath("//td[@id='firstHalfDayClass-2024-05-03']")).click();
        driver.findElement(By.xpath("//td[@id='lastHalfDayClass-2024-05-03']")).click();
        driver.findElement(By.xpath("//td[@id='firstHalfDayClass-2024-05-06']")).click();
        driver.findElement(By.xpath("//td[@id='lastHalfDayClass-2024-05-06']")).click();

        driver.findElement(By.id("delete-selection")).click();

        WebElement pgTitleAbs = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@id='pageTitle']")));

        return pgTitleAbs.getText();
    }

    public String remuneration() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // WebElement accueil =
        // wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='logosoprahr']")));
        // accueil.click();
        // WebElement nextButton =
        // wait.until(ExpectedConditions.elementToBeClickable(By.id("fromSydToPc")));
        // nextButton.click();
        WebElement remuneratuionButton = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='icon-shrs-icon-remuneration']")));
        remuneratuionButton.click();
        WebElement content = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("monthlyContractualSalary")));

        return content.getText();

    }

    public void demarche() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement menu = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='fa fa-bars fa-lg']")));
        menu.click();
        WebElement demarcheButton = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id='mainMenuList']//li[5]")));
        demarcheButton.click();
    }

    public String demendeAvance(int Date, int argent) {
        Actions connection = new Actions();
        connection.demarche();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement paie = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Ma paie']")));
        paie.click();

        WebElement avance = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[@id='demarcheElementmyDepositOrAdvanceRequest']//h4[@class='solo']")));
        avance.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        WebElement elementInShadowDom = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("your_css_selector")));

        // Execute the JavaScript selector and store the result
        elementInShadowDom = (WebElement) ((JavascriptExecutor) driver).executeScript(
                "return document.querySelector(\"div:nth-child(33) > div:nth-child(1) > div:nth-child(1) > workflow-init:nth-child(1) > div:nth-child(1) > div:nth-child(2) > section:nth-child(2) > instance-view:nth-child(2) > div:nth-child(1) > div:nth-child(1) > instance:nth-child(3) > div:nth-child(1) > div:nth-child(1) > ngb-accordion:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > generator-form:nth-child(1) > form:nth-child(2) > dynamic-ng-bootstrap-form:nth-child(1) > dynamic-ng-bootstrap-form-control:nth-child(1) > div:nth-child(1) > div:nth-child(1) > search-select-control:nth-child(1) > addons-html:nth-child(1) > search-select-accessor:nth-child(2) > div:nth-child(1) > div:nth-child(2) > ng-select:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)\");");

        if (elementInShadowDom != null) {
            // Click on the element
            elementInShadowDom.click();
        } else {
            System.out.println("Element not found.");
        }
        // WebElement typeDemande = wait
        // .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='ng-arrow-wrapper']")));
        // typeDemande.click();

        WebElement montant = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//input[@class='form-control ng-pristine ng-valid ng-star-inserted ng-touched' and @type='text' and @aria-required='true' and @aria-invalid='true']")));
        montant.sendKeys(String.valueOf(argent));

        WebElement acompte = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//div[@class='ng-option ng-option-selected ng-star-inserted' and @role='option' and @aria-selected='true' and starts-with(@id, 'a70db79ea35f-')]")));
        acompte.click();

        // Locating the input field for the date and inputting the date value
        WebElement mois = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='mat-input-2']")));
        mois.sendKeys(String.valueOf(Date));
        return null;
    }

    public String maladie(int Date) {
        Actions connection = new Actions();
        connection.demarche();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement donneIndividuelle = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='pt-wrapper foryou-header-nav collaborator-space-navbar']//div[11]//div[1]")));
        donneIndividuelle.click();
        WebElement maladie = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='demarcheElementimsick']//a[@id='null']")));
        maladie.click();

        WebElement declarer = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='headingDeclarer']")));
        declarer.click();
        WebElement justificatif = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='dateFin']")));
        justificatif.click();
        WebElement dateFin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='dateFin']")));
        dateFin.sendKeys(String.valueOf(Date));
        WebElement joindreJustificatif = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//div[@id='headingJustifier']//div[@class='panel-title']")));
        joindreJustificatif.click();

        WebElement decline = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Quitter']")));
        decline.click();
        WebElement confirmDecline = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Non']")));
        confirmDecline.click();
        return null;

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Actions connection = new Actions();
        connection.invokeBrowser();
        connection.login("SCONGE16", "4YOU");
        // connection.getTitle();
        // connection.getWelcomMessage();
        connection.checkAbsDays();
    }

}
