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

    public PlaceOrderData(String title, String description, String cost, String city, String phoneNumber, String email) {
        this.title = title;
        this.description = description;
        this.cost = cost;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public static boolean PlaceOrder(PlaceOrderData order) {
        PlaceOrder1(order);
        if (!OrderStatusCheck()) {
            return false;
        }
        PlaceOrder2(order);
        if (!OrderStatusCheck2()) {
            return false;
        }
        PlaceOrder3(order);
        if (!OrderStatusCheck3()) {
            return false;
        }
        return true;
    }

    public static void PlaceOrder2(PlaceOrderData order) {
        String filePath = "C:\\Users\\Andrew\\IdeaProjects\\TestElenta\\src\\main\\resources\\Photo\\slota.jpg";
        driver.findElement(By.id("inputfile")).sendKeys(filePath);
        PlaceOrderData.driver.findElement(By.id("forward-button")).click();


    }

    public static void PlaceOrder3(PlaceOrderData order) {
        PlaceOrderData.driver.findElement(By.id("forward-button")).click();

    }

    public static void PlaceOrder1(PlaceOrderData order) {
        PlaceOrderData.driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=Technika_Foto&actionId=Siulo&returnurl=%2Fskelbimai%2Fbuitis-laisvalaikis%2Fantikvariatas");
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
/*
        String filePath = "C:\\Users\\Andrew\\IdeaProjects\\TestElenta\\src\\main\\resources\\Photo\\slota.jpg";
        driver.findElement(By.id("inputfile")).sendKeys(filePath);
        PlaceOrderData.driver.findElement(By.id("forward-button")).click();
        PlaceOrderData.driver.findElement(By.xpath("/html/body/div[1]/div[3]/input[2]")).click();


 */
    }

    public static boolean OrderStatusCheck3() {
        return true;
    }

    public static boolean OrderStatusCheck2() {
        return true;
    }

    public static boolean OrderStatusCheck() {
        boolean output = true;

        if (!driver.findElements(By.xpath("/html/body/div[1]/ul/li/div[4]")).isEmpty()) {
            logout();
            return true;
        }
        List<WebElement> errorTitleInput = driver.findElements(By.id("te"));
        List<WebElement> errorDescriptionInput = driver.findElements(By.id("txte"));
        List<WebElement> errorPhoneNoNumber = driver.findElements(By.id("ce"));
        List<WebElement> errorPhoneNumberInputs = driver.findElements(By.id("be"));

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
        if (errorPhoneNoNumber.size() > 0) {
            System.out.println(errorPhoneNoNumber.get(0).getText());
            output = false;
        }

        return output;
    }

    public static void logout() {
        driver.get("https://elenta.lt/");
    }
}
