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
            JavascriptExecutor js= (JavascriptExecutor) wd;

            type(By.id("firstName"), student.getName());
            type(By.id("lastName"), student.getLastname());
            type(By.id("userEmail"), student.getEmail());


            switch (str){
                case "Male":
                    //click(By.cssSelector("#gender-radio-1"));
                    js.executeScript("document.querySelector('#gender-radio-1').checked=true;");
                    js.executeScript("document.querySelector('#gender-radio-1').click();");


                    break;
                case "Female":
                    //click(By.id("gender-radio-2"));
                    js.executeScript("document.querySelector('#gender-radio-2').checked=true;");
                    js.executeScript("document.querySelector('#gender-radio-2').click();");
                    break;
                case "Other":
                    //click(By.id("gender-radio-3"));
                    js.executeScript("document.querySelector('#gender-radio-3').checked=true;");
                    js.executeScript("document.querySelector('#gender-radio-3').click();");
                    break;
                default:
                    System.out.println("Error");

                    }
                    type(By.id("userNumber"), student.getNumber());



        }

    }

    private boolean isStudentCreationFormPresent() {
        Boolean isForm = new WebDriverWait(wd,5).until(ExpectedConditions.textToBePresentInElement(wd.findElement(By.cssSelector("h5")),"Student Registration Form"));

        return isForm;
    }
}
