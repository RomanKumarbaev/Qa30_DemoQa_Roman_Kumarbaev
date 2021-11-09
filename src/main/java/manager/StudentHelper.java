package manager;

import models.Student;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.LinkedList;
import java.util.List;

public class StudentHelper extends HelperBase {


    public StudentHelper(WebDriver wd) {
        super(wd);
    }

    public void selectItemForms() {
        if (isElementPresent(By.id("close-fixedban"))) {
            click(By.id("close-fixedban"));
        }
        click(By.xpath("//div[@class='category-cards']/div[2]"));
        pause(500);
    }

    public void selectPracticeForm() {
        click(By.xpath("//span[.='Practice Form']"));
    }


    public void fillStudentForm(Student student) {

        type(By.id("firstName"), student.getName());
        type(By.id("lastName"), student.getLastname());
        type(By.id("userEmail"), student.getEmail());

        selectGender(student.getGender());

        type(By.id("userNumber"), student.getNumber());

        typeBdaySelect(student.getBirthday());

        addSubject(student.getSubject());

        selectHobby(student.getHobbies());

        type(By.id("currentAddress"),student.getAddress());


        pause(3000);


    }

    private void selectHobby(String hobbies) {
        String [] hob = hobbies.split(",");

        for (String h:hob){

            switch (h){
                case "Sports":
                    click(By.xpath("//label[.='Sports']"));
                    break;
                case "Reading":
                    click(By.xpath("//label[.='Reading']"));
                    break;
                case "Music":
                    click(By.xpath("//label[.='Music']"));
                default:
                    System.out.println("Error");
            }

        }

    }

    private void addSubject(String subject) {

        String [] allSub = subject.split(",");

        click(By.id("subjectsInput"));

        for (String sub: allSub) {
            wd.findElement(By.id("subjectsInput")).sendKeys(sub);
            click(By.id("react-select-2-option-0"));

            pause(500);
        }

    }

    private void typeBdaySelect(String birthday) {
        String[] bData = birthday.split(" ");
        String bDay = String.format("//div[text()='%s']", bData[0]);

        click(By.id("dateOfBirthInput"));

        new Select(wd.findElement(By.cssSelector(".react-datepicker__month-select"))).selectByVisibleText(bData[1]);
        new Select(wd.findElement(By.cssSelector(".react-datepicker__year-select"))).selectByValue(bData[2]);

        List<WebElement> list = wd.findElements(By.xpath(bDay));

        if (list.size()>1 && Integer.parseInt(bData[0])>15){

            list.get(1).click();
        } else{
            list.get(0).click();
        }


    }

    private void selectGender(String gender) {

       // JavascriptExecutor js = (JavascriptExecutor) wd;

        switch (gender) {
            case "Male":
                click(By.xpath("//label[@for='gender-radio-1']"));
//                js.executeScript("document.querySelector('#gender-radio-1').checked=true;");
//                js.executeScript("document.querySelector('#gender-radio-1').click();");


                break;
            case "Female":
                click(By.xpath("//label[@for='gender-radio-2']"));
//                js.executeScript("document.querySelector('#gender-radio-2').checked=true;");
//                js.executeScript("document.querySelector('#gender-radio-2').click();");
                break;
            case "Other":
                click(By.xpath("//label[@for='gender-radio-3']"));
//                js.executeScript("document.querySelector('#gender-radio-3').checked=true;");
//                js.executeScript("document.querySelector('#gender-radio-3').click();");
                break;
            default:
                System.out.println("Error");

        }


    }


    public void uploadPicture() {
        wd.findElement(By.id("uploadPicture")).sendKeys("C:\\QA30\\Qa30_DemoQa_Roman_Kumarbaev\\two-females-banner-image.jpg");
    }

    public void submit() {
        click(By.id("submit"));
    }

    public String getTitleFromDialog() {

       if(wd.findElements(By.id("example-modal-sizes-title-lg")).size()>0){

           return "Thanks for submitting the form";
       } else

                   return null;
    }

    public void closeSuccessDialog() {
        click(By.id("closeLargeModal"));
    }
}
