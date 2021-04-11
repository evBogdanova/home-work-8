package tests;

import org.junit.jupiter.api.Test;

public class StudentRegistrationTest extends TestBase{
    StudentRegistrationPage studentRegistrationPage = new StudentRegistrationPage();

    @Test
    void studentRegistrationForm() {
        Student student = new Student();
        studentRegistrationPage.openPage();
        studentRegistrationPage.fillForm(student);
        studentRegistrationPage.checkForm(student);
        }
    }
