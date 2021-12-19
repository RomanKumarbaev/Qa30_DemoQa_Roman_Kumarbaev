package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;
    AlertHelper alert;
    StudentHelper studentHelper;
    ActionHelper action;

    public void init() {
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.navigate().to("https://demoqa.com/");

        alert = new AlertHelper(wd);
        studentHelper = new StudentHelper(wd);
        action = new ActionHelper(wd);

        alert.hideFooter();


    }
    public void stop() {
        wd.quit();
    }

    public AlertHelper alert() {
        return alert;
    }

    public ActionHelper action() {
        return action;
    }

    public StudentHelper studentHelper() {
        return studentHelper;
    }
}
