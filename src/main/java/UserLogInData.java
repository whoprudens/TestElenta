import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UserLogInData {
    public String name;
    public String password;
    public static WebDriver driver;

    public UserLogInData (String name, String password) {
        this.name = name;
        this.password = password;
    }

    public static boolean LogInUser (UserLogInData user) {
        UserLogInData.driver.get("https://elenta.lt/prisijungti");
        WebElement name = driver.findElement(By.id("UserName"));
        name.sendKeys(user.name);
        WebElement passwordInput = driver.findElement(By.id("Password"));
        passwordInput.sendKeys(user.password);
        WebElement submitButton = driver.findElement(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[4]/td[2]/input"));
        submitButton.click();

        return checkLogInFromStatus();
    }

    public static boolean checkLogInFromStatus() {
        boolean output = true;

        if (!driver.findElements(By.id("my-ads-nav-button")).isEmpty()) {
            logout();
            return true;
        }
        List<WebElement> errorNameInput = driver.findElements(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[1]/td[2]/span"));
        List<WebElement> errorPasswordInput = driver.findElements(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[3]/td[2]/span"));
        List<WebElement> errorAllInputs = driver.findElements(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[5]/td/div"));

        if (errorNameInput.size() > 0) {
            System.out.println(errorNameInput.get(0).getText());
            output = false;
        }

        if (errorPasswordInput.size() > 0) {
            System.out.println(errorPasswordInput.get(0).getText());
            output = false;
        }

        if (errorAllInputs.size() > 0) {
            System.out.println(errorAllInputs.get(0).getText());
            output = false;
        }

        return output;
    }

    public static void logout() {
        driver.findElement(By.id("my-ads-nav-button")).click();
        driver.findElement(By.xpath("//*[@id=\"main-container\"]/table/tbody/tr[1]/td[3]/a[2]")).click();
    }
}
