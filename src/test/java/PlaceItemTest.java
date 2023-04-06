import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.time.Duration;
import static org.testng.Assert.*;

public class PlaceItemTest {
    @Test
    public void PlaceTrueItemTest() {
        assertTrue(PlaceOrderData.PlaceOrder(new PlaceOrderData("Šluota", "Šluoja viską, ypač vyrus pro duris", "9999", "Vilnius", "861112222", "asigalis@mail.com")));
    }

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.Drivers", "\\chromedriver112.exe");
        PlaceOrderData.driver = new ChromeDriver();
        PlaceOrderData.driver.manage().window().maximize();
        PlaceOrderData.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        PlaceOrderData.driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=Technika_Foto&actionId=Siulo&returnurl=%2Fskelbimas%2Fvaldymas%2F1041187%2F023db122-3158-4f2f-b2ab-a08cff1b8cec");
        PlaceOrderData.driver.findElement(By.xpath("/html/body/div[5]/div[2]/div[1]/div[2]/div[2]/button[1]")).click();
    }
}