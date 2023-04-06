import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UserDataTest {
    public String name;
    public String email;
    public String password;
    public String reenterPassword;
    public static WebDriver driver;

    public UserDataTest(String name, String email, String password, String reenterPassword) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.reenterPassword = reenterPassword;
    }

    public static boolean registerUser(UserDataTest user) {
        UserDataTest.driver.get("https://elenta.lt/registracija");
        WebElement name = driver.findElement(By.id("UserName"));
        name.sendKeys(user.name);
        WebElement emailInput = driver.findElement(By.id("Email"));
        emailInput.sendKeys(user.email);
        WebElement passwordInput = driver.findElement(By.id("Password"));
        passwordInput.sendKeys(user.password);
        WebElement repeatPasswordInput = driver.findElement(By.id("Password2"));
        repeatPasswordInput.sendKeys(user.reenterPassword);
        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"main-container\"]/form/fieldset/table/tbody/tr[11]/td[2]/input"));
        submitButton.click();

        return checkRegistrationFromStatus();
    }

    public static boolean checkRegistrationFromStatus() {
        boolean output = true;

        if (!driver.findElements(By.xpath("//*[@id=\\\"main-container\\\"]/div[2]")).isEmpty()) {
            logout();
            return true;
        }

        List<WebElement> errorMessages = driver.findElements(By.xpath("//*[@id=\\\"main-container\\\"]/form/fieldset/table/tbody/tr[1]/td[2]/span"));
        if (!errorMessages.isEmpty()) {
            System.out.println(errorMessages.get(0).getText());
            output = false;
        }

        return output;
    }


    public static boolean LogInUser(UserDataTest user) {
        UserDataTest.driver.get("https://elenta.lt/prisijungti?returnurl=https%3A%2F%2Felenta.lt%2F");
        WebElement name = driver.findElement(By.id("UserName"));
        name.sendKeys(user.name);
        WebElement passwordInput = driver.findElement(By.id("Password"));
        passwordInput.sendKeys(user.password);
        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"form\"]/fieldset/table/tbody/tr[4]/td[2]/input"));
        submitButton.click();

        return true;
    }

    public static boolean checkLogInFromStatus() {
        boolean output = true;

        if (!driver.findElements(By.xpath("//*[@id=\\\"main-container\\\"]/div[2]")).isEmpty()) {
            logout();
            return true;
        }

        List<WebElement> errorMessages = driver.findElements(By.xpath("//*[@id=\\\"main-container\\\"]/form/fieldset/table/tbody/tr[1]/td[2]/span"));
        if (!errorMessages.isEmpty()) {
            System.out.println(errorMessages.get(0).getText());
            output = false;
        }

        return output;
    }

    public static void logout() {
        driver.get("https://elenta.lt/prisijungimas");
    }

}

////*[@id="form"]/fieldset/table/tbody/tr[5]/td/div




 /*  public static boolean checkRegistrationFromStatus(){
        boolean output = true;

        if(!driver.findElements(By.xpath("//*[@id=\"main-container\"]/div[2]")).isEmpty()){
            logout();
            return true;
        }

        List<WebElement> nameExists = driver.findElements(By.xpath("//*[@id=\"main-container\"]/form/fieldset/table/tbody/tr[1]/td[2]/span"));
        List<WebElement> enterName = driver.findElements(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[1]/td[2]/span"));
        if (!nameExists.get(0).getText().contains("https://elenta.lt")){
            System.out.println(nameExists.get(0).getText());
            output = false;
        }
        if (!enterName.isEmpty()){
            System.out.println(enterName.get(0).getText());
            output = false;
        }
        return output;
    }

   */