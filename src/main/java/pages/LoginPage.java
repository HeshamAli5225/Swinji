package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    By emailField = By.id("Email");
    By passwordField = By.id("inputPassword");
    By loginBtn = By.id("btnLogin");

    public void login(String email, String password) {

        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginBtn).click();

    }
}
