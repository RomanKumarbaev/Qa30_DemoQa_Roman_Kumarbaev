package models;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@Builder
@ToString

public class StudentEnum {


    String name;
    String lastname;
    String email;
    String gender;
    String number;
    String birthday;
    String subject;
    //String hobbies;
    //Hobby hobby;
    List<Hobby> hobbies;
    String address;
    String state;
    String city;

}
