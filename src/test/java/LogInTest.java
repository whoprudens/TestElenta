import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.time.Duration;
import static org.testng.Assert.*;
public class LogInTest {
    @Test
    public void LogInTest(){
        assertTrue(UserDataTest.LogInUser(new UserDataTest("Grybųgrybas", "hustla.bulls@gmail.com", "balandisuzlango", "balandisuzlango")));
    }
    @BeforeClass
    public void beforeClass() {
        // System.setProperty("webdriver.chrome.Drivers", "\\chromedriver112.exe");
        UserDataTest.driver = new ChromeDriver();
        UserDataTest.driver.manage().window().maximize();
        UserDataTest.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        UserDataTest.driver.get("https://elenta.lt/prisijungti?returnurl=https%3A%2F%2Felenta.lt%2F");
        UserDataTest.driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[1]/div[2]/div[2]/button[1]")).click();

    }
}
