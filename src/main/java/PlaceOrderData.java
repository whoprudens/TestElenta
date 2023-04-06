import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import static org.junit.Assert.*;
public class PlaceOrderData {

    public String title;
    public String description;
    public String cost;
    public String city;
    public String phoneNumber;
    public String email;
    public static WebDriver driver;

    public PlaceOrderData (String title, String description, String cost, String city, String phoneNumber, String email) {
        this.title = title;
        this.description = description;
        this.cost = cost;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    public static boolean PlaceOrder(PlaceOrderData order){
        PlaceOrderData.driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=Technika_Foto&actionId=Siulo&returnurl=%2Fskelbimas%2Fvaldymas%2F1041187%2F023db122-3158-4f2f-b2ab-a08cff1b8cec");
        WebElement title = driver.findElement(By.id("title"));
        title.sendKeys(order.title);
        WebElement description = driver.findElement(By.id("text"));
        description.sendKeys(order.description);
        WebElement cost = driver.findElement(By.id("price"));
        cost.sendKeys(order.cost);
        WebElement city = driver.findElement(By.id("location-search-box"));
        city.sendKeys(order.city);
        WebElement phoneNumber = driver.findElement(By.id("phone"));
        phoneNumber.sendKeys(order.phoneNumber);
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys(order.email);
        PlaceOrderData.driver.findElement(By.id("submit-button")).click();
        PlaceOrderData.driver.findElement(By.id("inputfile")).click();
        PlaceOrderData.driver.findElement(By.id("forward-button")).click();
        PlaceOrderData.driver.findElement(By.xpath("/html/body/div[1]/div[3]/input[2]")).click();
        return OrderStatusCheck();
    }

    public static boolean OrderStatusCheck() {
        boolean output = true;

        if (!driver.findElements(By.id("my-ads-nav-button")).isEmpty()) {
            logout();
            return true;
        }
        List<WebElement> errorTitleInput = driver.findElements(By.xpath("/html/body/div[1]/div[2]/form/div[1]/label/span"));
        List<WebElement> errorDescriptionInput = driver.findElements(By.xpath("/html/body/div[1]/div[2]/form/div[2]/label/span"));
        List<WebElement> errorPhoneNumberInputs = driver.findElements(By.xpath("/html/body/div[1]/div[2]/form/div[5]/span[3]"));

        if (errorTitleInput.size() > 0) {
            System.out.println(errorTitleInput.get(0).getText());
            output = false;
        }

        if (errorDescriptionInput.size() > 0) {
            System.out.println(errorDescriptionInput.get(0).getText());
            output = false;
        }

        if (errorPhoneNumberInputs.size() > 0) {
            System.out.println(errorPhoneNumberInputs.get(0).getText());
            output = false;
        }

        return output;
    }

public static void logout(){
        driver.get("https://elenta.lt/");
}
}
