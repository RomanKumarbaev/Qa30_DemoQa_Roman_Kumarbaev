package tests;

import models.Hobby;
import models.Student;
import models.StudentEnum;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

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
        app.studentHelper().pause(3000);
        app.studentHelper().submit();
        app.studentHelper().pause(5000);

        Assert.assertEquals(app.studentHelper().getTitleFromDialog(),"Thanks for submitting the form");
        app.studentHelper().closeSuccessDialog();


    }


    @Test
    public void studentFormTestEnum(){

        int i=(int) ((System.currentTimeMillis()/1000)%3600);

        List<Hobby> hobbies = new ArrayList<>();
        hobbies.add(Hobby.MUSIC);
        hobbies.add(Hobby.READING);

        StudentEnum student = StudentEnum.builder()
                .name("Vasya")
                .lastname("Pupkin")
                .email("vasya"+i+"@gmail.com")
                .gender("Female")
                .number("1234567890")
                .birthday("11 December 1992")
                .subject("Economics,Social Studies,Maths")
                .hobbies(hobbies)
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
