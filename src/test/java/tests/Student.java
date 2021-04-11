package tests;

import com.github.javafaker.Faker;

import java.util.List;

public class Student {
    private final Faker faker = new Faker();
    private final String firstName = faker.name().firstName();
    private final String lastName = faker.name().lastName();
    private final String userEmail = faker.internet().emailAddress();
    private final String gender = "Female";
    private final String userNumber = faker.number().digits(10);
    private final String dayOfBirth = "19";
    private final String monthOfBirth = "November";
    private final String yearOfBirth = "1997";
    private final List<String> subjects = List.of("Biology", "Computer Science");
    private final String hobby = "Music";
    private final String picture = "test.jpg";
    private final String currentAddress = faker.address().fullAddress();
    private final String state = "NCR";

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getGender() {
        return gender;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public String getMonthOfBirth() {
        return monthOfBirth;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public String getHobby() {
        return hobby;
    }

    public String getPicture() {
        return picture;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    private String city = "Delhi";
}
