package models;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString

public class Student {
String name;
String lastname;
String email;
String gender;
String number;
String birthday;
String subject;
String hobbies;
String address;
String state;
String city;

}
