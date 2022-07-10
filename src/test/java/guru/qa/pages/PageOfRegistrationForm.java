package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;
import guru.qa.pages.pagecomponents.CalenderComponent;
import guru.qa.pages.pagecomponents.ResultDataFormComponent;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class PageOfRegistrationForm {
    private SelenideElement name = $("#firstName"),
            surname = $("#lastName"),
            email = $("#userEmail"),
            mobileNumber = $("#userNumber"),
            dateOfBirthField = $("#dateOfBirthInput"),
            subject = $("#subjectsInput"),
            picture = $("#uploadPicture"),
            address = $("#currentAddress"),
            state = $("#react-select-3-input"),
            city = $("#react-select-4-input"),
            submit = $("#submit"),
            resultForm = $(".modal-title");

    CalenderComponent calenderComponent = new CalenderComponent();
    ResultDataFormComponent resultDataFormComponent = new ResultDataFormComponent();

    @Step("Открываем страницу с полями для ввода данных и убираем рекламу")
    public PageOfRegistrationForm openingWebsiteWithoutAds() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    @Step("Вводим \"{userName}\" в поле \"First Name\"")
    public PageOfRegistrationForm settingFirstName(String userName) {
        name.setValue(userName);
        return this;
    }

    @Step("Вводим \"{userSurname}\" в поле \"Second Name\"")
    public PageOfRegistrationForm settingSurname(String userSurname) {
        surname.setValue(userSurname);
        return this;
    }

    @Step("Вводим \"{userEmail}\" в поле \"Email\"")
    public PageOfRegistrationForm settingEmail(String userEmail) {
        email.setValue(userEmail);
        return this;
    }

    @Step("Выбираем \"{userGender}\" близ \"Gender\"")
    public PageOfRegistrationForm settingGender(int userGender) {
        $(String.format("#gender-radio-%s", userGender)).sendKeys(" ");
        return this;
    }

    @Step("Вводим \"{userMobileNumber}\" в поле \"Mobile Number\"")
    public PageOfRegistrationForm settingMobileNumber(String userMobileNumber) {
        mobileNumber.setValue(userMobileNumber);
        return this;
    }

    @Step("Вводим \"{dayOfBirth} {monthOfBirth} {yearOfBirth}\" в поле даты")
    public PageOfRegistrationForm settingDateOfBirth(int dayOfBirth, String monthOfBirth, int yearOfBirth) {
        dateOfBirthField.click();
        calenderComponent.settingDateOfBirthInCalender(dayOfBirth, monthOfBirth, yearOfBirth);
        return this;
    }

    @Step("Вводим \"{userSubject}\" в поле близ \"Subject\"")
    public PageOfRegistrationForm settingSubject(String userSubject) {
        subject.sendKeys(userSubject);
        subject.sendKeys(Keys.RETURN);
        return this;
    }

    @Step("Выбираем \"{userHobbies}\" близ \"Hobbies\"")
    public PageOfRegistrationForm settingHobbies(int userHobbies) {
        $(String.format("#hobbies-checkbox-%s", userHobbies)).sendKeys(" ");
        return this;
    }

    @Step("Загружаем \"{userPicture}\" через \"Выберите файл\"")
    public PageOfRegistrationForm uploadingPicture(String userPicture) {
        $("#uploadPicture").uploadFile(new File(userPicture));
        return this;
    }

    @Step("Вводим \"{userAddress}\" в поле \"Current Address\"")
    public PageOfRegistrationForm settingAddress(String userAddress) {
        address.setValue(userAddress);
        return this;
    }

    @Step("Вводим \"{userState}\" в поле \"Select State\"")
    public PageOfRegistrationForm selectingState(String userState) {
        state.setValue(userState).sendKeys(Keys.RETURN);
        return this;
    }

    @Step("Вводим \"{userCity}\" в поле \"Select City\"")
    public PageOfRegistrationForm selectingCity(String userCity) {
        city.setValue(userCity).sendKeys(Keys.RETURN);
        return this;
    }

    @Step("Клик по кнопке \"Submit\"")
    public PageOfRegistrationForm clickingOnSubmit() {
        submit.click();
        return this;
    }

    @Step("Проверяем наличие \"{validateFieldValue}\" в результатах общего вывода")
    public PageOfRegistrationForm checkingResultFormValues(String validateFieldValue) {
        resultDataFormComponent.checkingResultFormValues(validateFieldValue);
        return this;
    }
}