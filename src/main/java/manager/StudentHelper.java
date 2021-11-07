package manager;

import models.Student;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StudentHelper extends HelperBase{


    public StudentHelper(WebDriver wd) {
        super(wd);
    }

    public void selectItemForms() {
        if(isElementPresent(By.id("close-fixedban"))) {
            click(By.id("close-fixedban"));
        }
        click(By.xpath("//div[@class='category-cards']/div[2]"));
        pause(500);
    }

    public void selectPracticeForm() {
        click(By.xpath("//span[.='Practice Form']"));
    }


    public void fillStudentForm(Student student) {

        if(isStudentCreationFormPresent()){

            String str = student.getGender();

            type(By.id("firstName"), student.getName());
            type(By.id("lastName"), student.getLastname());
            type(By.id("userEmail"), student.getEmail());
            type(By.id("userNumber"), student.getNumber());

            switch (str){
                case "Male":
                    click(By.id("gender-radio-1"));
                    break;
                case "Female":
                    click(By.id("gender-radio-2"));
                    break;
                case "Other":
                    click(By.id("gender-radio-3"));
                    break;
                default:
                    System.out.println("Error");

                    }



        }

    }

    private boolean isStudentCreationFormPresent() {
        Boolean isForm = new WebDriverWait(wd,5).until(ExpectedConditions.textToBePresentInElement(wd.findElement(By.cssSelector("h5")),"Student Registration Form"));

        return isForm;
    }
}
