
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CoursesPage;
import pages.CreateCoursePage;
import pages.HomePage;
import pages.LoginPage;
import utilities.DataProviders;


public class TestCases {

    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    CoursesPage coursesPage;
    CreateCoursePage createCoursePage;

    @BeforeTest
    public void openUrl(){
        driver=new FirefoxDriver();
        driver.navigate().to("https://swinji.azurewebsites.net/account/login");
        loginPage=new LoginPage(driver);
        homePage=new HomePage(driver);
        coursesPage=new CoursesPage(driver);
        createCoursePage=new CreateCoursePage(driver);
    }



    @Test(priority = 1,dataProvider ="login_data",dataProviderClass = DataProviders.class)

    public void loginTest(String email,String password){

        loginPage.login(email,password);

    }
    @Test(priority = 2,dataProvider ="course_name",dataProviderClass = DataProviders.class)

    public void addCourseTest(String courseName)  {
        homePage.courses();
        coursesPage.openCreateCourse();
        createCoursePage.fillCourseInfo(courseName);
        boolean isCreated=coursesPage.isCourseTitleDisplayed(courseName);
        Assert.assertTrue(isCreated);
    }

    @AfterTest
    public void close(){
        driver.quit();
    }

}
