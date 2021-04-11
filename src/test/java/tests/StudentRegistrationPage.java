package tests;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class StudentRegistrationPage {


    public void openPage() {
        step("Открытие формы регистрации студента", () -> {
            open("https://demoqa.com/automation-practice-form");
            $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        });
    }

    public void fillForm(Student student) {
        step("Заполнение основной информации о студенте", () -> {
            $("#firstName").setValue(student.getFirstName());
            $("#lastName").setValue(student.getLastName());
            $("#userEmail").setValue(student.getUserEmail());
            $(byText(student.getGender())).click();
            $("#userNumber").setValue(student.getUserNumber());
        });

        step("Заполнение даты рождения студента", () -> {
            setBirthDate(student.getDayOfBirth(), student.getMonthOfBirth(), student.getYearOfBirth());
        });

        step("Заполнение предметов", () -> {
            student.getSubjects().forEach(x -> {
            $("#subjectsInput").setValue(x).pressEnter();
            });
        });

        step("Заполнение хобби студента", () -> {
            $(byText(student.getHobby())).click();
        });

        step("Загрузка фото", () -> {
            $("#uploadPicture").uploadFromClasspath(student.getPicture());
        });

        step("Заполнение адреса студента", () -> {
            $("#currentAddress").setValue(student.getCurrentAddress());
            $("#react-select-3-input").setValue(student.getState()).pressEnter();
            $("#react-select-4-input").setValue(student.getCity()).pressEnter();
            $("#submit").click();
        });
    }

    public void setBirthDate(String dayOfBirth, String monthOfBirth, String yearOfBirth) {
        $(byId("dateOfBirthInput")).click();
        $(".react-datepicker__month-select").selectOptionContainingText(monthOfBirth);
        $(".react-datepicker__year-select").selectOptionByValue(yearOfBirth);
        $(".react-datepicker__day--0" + dayOfBirth).click();
    }

    public void checkForm(Student student) {
        step("Проверка заполненной тнформации", () -> {
        $(".table-responsive").shouldHave(text("Student Name " + student.getFirstName() + " " + student.getLastName()),
                text("Student Email " + student.getUserEmail()),
                text("Gender " + student.getGender()),
                text("Mobile " + student.getUserNumber()),
                text("Date of Birth " + student.getDayOfBirth() + " " + student.getMonthOfBirth() + "," + student.getYearOfBirth()),
                text("Subjects " + student.getSubjects().get(0) + ", " + student.getSubjects().get(1)),
                text("Hobbies " + student.getHobby()),
                text("Picture " + student.getPicture()),
                text("Address " + student.getCurrentAddress()),
                text("State and City " + student.getState() + " " + student.getCity()));
        });
    }
}
