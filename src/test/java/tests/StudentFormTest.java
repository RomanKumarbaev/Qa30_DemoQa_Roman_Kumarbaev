package tests;

import models.Student;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StudentFormTest extends TestBase {

    @BeforeMethod
    public void preconditions(){
        app.studentHelper().selectItemForms();
        app.studentHelper().selectPracticeForm();
        app.studentHelper().hideFooter();

    }

    @Test
    public void studentFormTest(){

        int i=(int) ((System.currentTimeMillis()/1000)%3600);

        Student student = Student.builder()
                .name("Vasya")
                .lastname("Pupkin")
                .email("vasya"+i+"@gmail.com")
                .gender("Female")
                .number("1234567890")
                .birthday("11 December 1992")
                .subject("Economics,Social Studies,Maths")
                .hobbies("Sports,Music")
                .address("Rishon LeZion")
                .state("NCR")
                .city("Gurgaon")
                .build();

        app.studentHelper().fillStudentForm(student);
        app.studentHelper().uploadPicture();
        app.studentHelper().pause(500);
        app.studentHelper().submit();
        app.studentHelper().pause(1000);

        Assert.assertEquals(app.studentHelper().getTitleFromDialog(),"Thanks for submitting the form");
        app.studentHelper().closeSuccessDialog();







    }

}
