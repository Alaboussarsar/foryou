import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeoutException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestGenerator {

    static WebDriver driver;

    public static Actions connection;

    @BeforeAll
    static void beforeAll() {
        connection = new Actions();
    }

    @AfterAll
    static void afterAll() {
        connection.closeDriver();
    }

    @Test
    @Order(1)
    public void TestingWebsiteTitle() {
        connection.invokeBrowser();

        String actualTitle = connection.getTitleforTest();
        assertEquals("4YOU - Se connecter", actualTitle);
    }

    @Test
    @Order(2)
    public void TestingLogin() {
        String email = "MARWEN";
        String password = "HR";
        connection.login(email, password);

        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertEquals("4YOU - Start your day", connection.driver.getTitle());
    }
    /*
    @Test
    @Order(3)
    public void IfWelcomMessage() {

        String actualTitle = connection.ErrorMessage();
        assertEquals("Nous ne reconnaissons pas vos identifiants. Merci de réessayer !", actualTitle);
    }

    */
    @Test
    @Order(3)
    public void IfWelcomMessage() {

        String actualTitle = connection.waitForToastMessage();
        assertEquals("Vous vous êtes connecté(e) avec succès !", actualTitle);
    }

    @Test
    @Order(4)
    public void testEmployeeDetails() {

        String actualFullName = connection.checkIdForEmployee();
        String actualJob = connection.checkJobForEmployee();

        assertEquals("Philippe FAYE", actualFullName);
        assertEquals("OUVRIER QUALIFIÉ", actualJob);
    }

    @Test
    @Order(5)
    public void TestPgTitle() {
        String PgTitle = connection.pageTitle1();

        assertEquals("Profil collaborateur", PgTitle);
    }

    @Test
    @Order(6)
    public void TestAbsDays() {
        String absDays = connection.checkAbsDays();

        assertEquals("Aucun droit de congé à ce jour.", absDays);
    }
    /*@Test
    @Order(7)
    public void TestWorkVacation()  {
        String pageTitleAbs = connection.workVacation();

        assertEquals("Mes absences", pageTitleAbs);
    }
    */
    @Test
    @Order(7)
    public void Testremuneration() {
        String content = connection.remuneration();

        assertEquals("2 000,00 €", content);
    }
    /*
        @Test
        @Order(8)
        public void TestDemandAvance() {
            String content = connection.demendeAvance(222025,600);


        }
    */
   /* @Test
    @Order(8)
    public void Testmaladie() {
        int Date = 22112025 ;
        connection.maladie(Date);
    }*/
}
