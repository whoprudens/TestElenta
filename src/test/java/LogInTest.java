import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.time.Duration;
import static org.testng.Assert.*;
public class LogInTest {
    @Test(priority = 1)
    public void LogInCorrectTest(){
        assertTrue(UserLogInData.LogInUser(new UserLogInData("Grybųgrybas", "balandisuzlango")));
    }
    @Test(priority = 2)
    public void LogInIncorrectTest(){
        assertFalse(UserLogInData.LogInUser(new UserLogInData("GrybųVadasBaravykas", "balandisuzlango")));
    }
    @Test(priority = 3)
    public void LogInNoNameTest(){
        assertFalse(UserLogInData.LogInUser(new UserLogInData("", "balandisuzlango")));
    }
    @Test(priority = 4)
    public void LogInNoPasswordTest(){
        assertFalse(UserLogInData.LogInUser(new UserLogInData("Grybųgrybas", "")));
    }
    @Test(priority = 4)
    public void LogInNoPasswordAndNoNameTest(){
        assertFalse(UserLogInData.LogInUser(new UserLogInData("", "")));
    }
    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.Drivers", "\\chromedriver112.exe");
        UserLogInData.driver = new ChromeDriver();
        UserLogInData.driver.manage().window().maximize();
        UserLogInData.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        UserLogInData.driver.get("https://elenta.lt/prisijungti");
        UserLogInData.driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[1]/div[2]/div[2]/button[1]")).click();

    }
}
