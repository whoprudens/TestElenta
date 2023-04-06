import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.time.Duration;
import static org.testng.Assert.*;
public class RegistrationTest {

    @Test(priority = 1)
    public void registerUserTest() {
        assertTrue(UserRegistrationData.registerUser(new UserRegistrationData("Grybųgrybaass", "grybugrybas12223334@gmail.com", "balandisuzlango", "balandisuzlango")));
    }

    @Test(priority = 2)
    public void registerUserExistTest() {
        assertFalse(UserRegistrationData.registerUser(new UserRegistrationData("Grybųgrybas", "grybugrybas1111@gmail.com", "balandisuzlango", "balandisuzlango")));
    }

    @Test(priority = 3)
    public void registerUserNoNameTest() {
        assertFalse(UserRegistrationData.registerUser(new UserRegistrationData("", "grybugrybas2222@gmail.com", "balandisuzlango", "balandisuzlango")));
    }
    @Test(priority = 4)
    public void registerUserSymbolNameTest() {
        assertFalse(UserRegistrationData.registerUser(new UserRegistrationData("!#(", "grybugrybasas333@gmail.com", "balandisuzlango", "balandisuzlango")));
    }
    @Test(priority = 4)
    public void registerUserNoMailTest() {
        assertFalse(UserRegistrationData.registerUser(new UserRegistrationData("Grybųgrybas", "", "balandisuzlango", "balandisuzlango")));
    }
    @Test(priority = 5)
    public void registerUserIncorrectMailTest() {
        assertFalse(UserRegistrationData.registerUser(new UserRegistrationData("Grybųgrybas1", "grybugrybas#pastas.com", "balandisuzlango", "balandisuzlango")));
    }
    @Test(priority = 6)
    public void registerUserExistMailTest() {
        assertFalse(UserRegistrationData.registerUser(new UserRegistrationData("Aloha", "hustla.bulls@gmail.com", "balandisuzlango", "balandisuzlango")));
    }
    @Test(priority = 7)
    public void registerUserNoPasswordTest() {
        assertFalse(UserRegistrationData.registerUser(new UserRegistrationData("Grybųgrybas122", "grybugrybas111234@gmail.com", "", "")));
    }
    @Test(priority = 8)
    public void registerUserIncorrectPasswordTest() {
        assertFalse(UserRegistrationData.registerUser(new UserRegistrationData("Grybųgrybas5", "grybugryba1234saa@gmail.com", "123", "123")));
    }
    @Test(priority = 9)
    public void registerUserNotMatchPasswordTest() {
        assertFalse(UserRegistrationData.registerUser(new UserRegistrationData("Grybųgrybas6", "grybugryba12333343s@gmail.com", "balandisuzlango", "nemeluokcia")));
    }



    @BeforeClass
    public void beforeClass() {
        // System.setProperty("webdriver.chrome.Drivers", "\\chromedriver112.exe");
        UserRegistrationData.driver = new ChromeDriver();
        UserRegistrationData.driver.manage().window().maximize();
        UserRegistrationData.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        UserRegistrationData.driver.get("https://elenta.lt/registracija");
        UserRegistrationData.driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[1]/div[2]/div[2]/button[1]")).click();

    }
}
/*
    @BeforeMethod
    public void beforeMethod() {
        UserDataTest.driver.get("https://elenta.lt/");
        UserDataTest.driver.findElement(By.xpath("/html/body/div[5]/div[2]/div[1]/div[2]/div[2]/button[1]")).click();
    }
}
/*
    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(5000);
        UserDataTest.driver.quit();
    }
}


 */