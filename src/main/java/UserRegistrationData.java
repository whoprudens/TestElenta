import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UserRegistrationData {
    public String name;
    public String email;
    public String password;
    public String reenterPassword;
    public static WebDriver driver;

    public UserRegistrationData(String name, String email, String password, String reenterPassword) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.reenterPassword = reenterPassword;
    }

    public static boolean registerUser(UserRegistrationData user) {
        UserRegistrationData.driver.get("https://elenta.lt/registracija");
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

        if (!driver.findElements(By.xpath("/html/body/div[1]/div[2]")).isEmpty()) {
            logout2();
            return true;
        }
        List<WebElement> errorNameExistAndNoName = driver.findElements(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[1]/td[2]/span"));
        List<WebElement> errorMailInputAndExistMail = driver.findElements(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[4]/td[2]/span"));
        List<WebElement> errorNoPasswordAndExistPass = driver.findElements(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[5]/td/div"));
        List<WebElement> errorPasswordToShort = driver.findElements(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[7]/td[2]/span"));
        List<WebElement> errorPasswordsNotMatchAndIncorrectInput = driver.findElements(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[8]/td[2]/span"));

        if (errorNameExistAndNoName.size() > 0) {
            System.out.println(errorNameExistAndNoName.get(0).getText());
            output = false;
        }

        if (errorMailInputAndExistMail.size() > 0) {
            System.out.println(errorMailInputAndExistMail.get(0).getText());
            output = false;
        }

        if (errorNoPasswordAndExistPass.size() > 0) {
            System.out.println(errorNoPasswordAndExistPass.get(0).getText());
            output = false;
        }

        if (errorPasswordsNotMatchAndIncorrectInput.size() > 0) {
            System.out.println(errorPasswordsNotMatchAndIncorrectInput.get(0).getText());
            output = false;
        }

        if (errorPasswordToShort.size() > 0) {
            System.out.println(errorPasswordToShort.get(0).getText());
            output = false;
        }

        return output;
    }

    public static void logout2() {
        driver.get("https://elenta.lt/prisijungti");
    }

}
