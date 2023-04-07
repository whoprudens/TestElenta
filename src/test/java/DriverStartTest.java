import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class DriverStartTest {

@BeforeSuite
    public void beforeSuite() {
    DriverStart.driver = new ChromeDriver();
    DriverStart.driver.manage().window().maximize();
    DriverStart.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    DriverStart.driver.get("https://elenta.lt/registracija");
    DriverStart.driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[1]/div[2]/div[2]/button[1]")).click();
}
}
