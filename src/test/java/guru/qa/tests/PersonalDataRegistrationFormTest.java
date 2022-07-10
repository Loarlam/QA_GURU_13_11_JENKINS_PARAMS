package guru.qa.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class PersonalDataRegistrationFormTest extends TestBaseIncludingBeforeAndAfterTests {
    @Test
    @Owner("Loarlam")
    @Severity(SeverityLevel.TRIVIAL)
    @Feature("Удаленные запуски автотестов с помощью Jenkins")
    @Story("Jenkins тянет код из гита, при отработке которого формируется отчёт в Allure Report")
    @Description("Методика запуска автотестов посредством подтягивания кода из github в Jenkins, с выводом отчёта Allure, позволяет решить проблему привязки к локальной машине")
    @Link(name = "Demoqa", url = "https://demoqa.com/automation-practice-form")
    @Tag("demoqa")
    @DisplayName("Заполнение формы сайта demoqa.com данными, с последующей сверкой результатов с итоговым выводом")
    void successfulTest() {
        pageOfRegistrationForm.openingWebsiteWithoutAds()
                .settingFirstName(dataForTheTest.userName)
                .settingSurname(dataForTheTest.userSurname)
                .settingEmail(dataForTheTest.userEmail)
                .settingGender(dataForTheTest.userGenderDigit)
                .settingMobileNumber(dataForTheTest.userPhoneNumber)
                .settingDateOfBirth(dataForTheTest.userDayOfBirth, dataForTheTest.userMonthOfBirth, dataForTheTest.userYearOfBirth)
                .settingSubject(dataForTheTest.userSubjectFirstLetter)
                .settingHobbies(dataForTheTest.userHobbiesDigit)
                .uploadingPicture(dataForTheTest.userPicture)
                .settingAddress(dataForTheTest.userAddress)
                .selectingState(dataForTheTest.userState)
                .selectingCity(dataForTheTest.userCity)
                .clickingOnSubmit()
                .checkingResultFormValues(dataForTheTest.userName + " " + dataForTheTest.userSurname)
                .checkingResultFormValues(dataForTheTest.userEmail)
                .checkingResultFormValues(dataForTheTest.userGenderName)
                .checkingResultFormValues(dataForTheTest.userPhoneNumber)
                .checkingResultFormValues(dataForTheTest.userDayOfBirth + " " + dataForTheTest.userMonthOfBirth + "," + dataForTheTest.userYearOfBirth)
                .checkingResultFormValues(dataForTheTest.userSubjectFirstLetter)
                .checkingResultFormValues(dataForTheTest.userHobbiesName)
                .checkingResultFormValues(dataForTheTest.userPictureShortPath)
                .checkingResultFormValues(dataForTheTest.userAddress)
                .checkingResultFormValues(dataForTheTest.userState + " " + dataForTheTest.userCity);
    }
}