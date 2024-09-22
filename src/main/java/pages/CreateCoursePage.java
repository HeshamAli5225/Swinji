package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateCoursePage {

    WebDriver driver;

    public CreateCoursePage(WebDriver driver) {
        this.driver = driver;
    }

    By name=By.id("txtCourseName");
    By SubjectList=By.id("courseSubject");
    String SubjectItemValue="number:7";

    By grade=By.id("courseGrade");
    String gradeItemValue="number:11";
    By teacherList=By.cssSelector("span.ui-select-placeholder.text-muted");
    By teacher=By.cssSelector("#ui-select-choices-row-0-1 > span:nth-child(1)");
    By createBtn=By.id("btnSaveAsDraftCourse");


    public void fillCourseInfo(String title) {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(name));

        driver.findElement(name).sendKeys(title);
        WebElement subjectMenu=driver.findElement(SubjectList);
        Select subjectList=new Select(subjectMenu);
        subjectList.selectByValue(SubjectItemValue);

        WebElement gradeMenu=driver.findElement(grade);
        Select gradeList=new Select(gradeMenu);
        gradeList.selectByValue(gradeItemValue);

        driver.findElement(teacherList).click();
        driver.findElement(teacher).click();


        driver.findElement(createBtn).click();

    }

}
