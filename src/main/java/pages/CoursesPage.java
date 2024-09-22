package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CoursesPage {

    WebDriver driver;

    public CoursesPage(WebDriver driver) {
        this.driver = driver;
    }

    By addCourseBtn=By.id("btnListAddCourse");
    By courseName=By.id("courseNameView");


    public void openCreateCourse() {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(addCourseBtn));
        driver.findElement(addCourseBtn).click();
    }

    public boolean isCourseTitleDisplayed(String title) {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(courseName));
        return driver.findElement(courseName).getText().equals(title);
    }
}
