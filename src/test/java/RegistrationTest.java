import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.time.Duration;
import static org.testng.Assert.*;
public class RegistrationTest {

    @Test(priority = 1)
    public void registerUserTest() {
        assertTrue(UserDataTest.registerUser(new UserDataTest("Grybųgrybak", "hustlk.bulls@gmail.com", "balandisuzlango", "balandisuzlango")));
    }

    @Test(priority = 2)
    public void registerUserExistTest() {
        assertTrue(UserDataTest.registerUser(new UserDataTest("Grybųgrybas9", "hustla8.bulls@gmail.com", "balandisuzlango", "balandisuzlango")));
    }

    @Test(priority = 3)
    public void registerUserNoNameTest() {
        assertTrue(UserDataTest.registerUser(new UserDataTest("", "hustla1.bulls@gmail.com", "balandisuzlango", "balandisuzlango")));
    }

    @BeforeClass
    public void beforeClass() {
        // System.setProperty("webdriver.chrome.Drivers", "\\chromedriver112.exe");
        UserDataTest.driver = new ChromeDriver();
        UserDataTest.driver.manage().window().maximize();
        UserDataTest.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        UserDataTest.driver.get("https://elenta.lt/registracija");
        UserDataTest.driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[1]/div[2]/div[2]/button[1]")).click();

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