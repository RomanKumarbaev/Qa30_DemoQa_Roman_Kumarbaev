package tests;

import models.Student;
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
                .gender("Male")
                .number("056-9886534")
                .build();
        app.studentHelper().selectPracticeForm();
        app.studentHelper().fillStudentForm(student);






    }

}
