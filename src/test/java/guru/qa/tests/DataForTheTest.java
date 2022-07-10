package guru.qa.tests;

import com.github.javafaker.Faker;
import guru.qa.enumvalues.Genders;
import guru.qa.enumvalues.Hobbies;
import guru.qa.utils.RandomUtils;

import java.time.Month;
import java.util.Locale;
import java.util.Random;

public class DataForTheTest {
    private char[] alphabetWithoutSeveralLetters = {'a', 'b', 'c', 'd', 'e', 'g', 'h', 'i', 'l', 'm', 'n', 'o', 'p', 'r', 's', 't', 'u', 'v', 'y'};

    Faker fakerData = new Faker(Locale.FRANCE);
    Random random = new Random();
    RandomUtils randomUtils = new RandomUtils();

    int userDayOfBirth = random.nextInt(28) + 1,
            userYearOfBirth = random.nextInt(101) + 1900,
            userGenderDigit = random.nextInt(Genders.values().length) + 1,
            userHobbiesDigit = random.nextInt(Hobbies.values().length) + 1;

    String userName = fakerData.funnyName().name(),
            userSurname = fakerData.name().lastName(),
            userEmail = fakerData.internet().safeEmailAddress(),
            userGenderName = Genders.values()[userGenderDigit - 1].getName(),
            userPhoneNumber = String.valueOf(random.nextInt(1000000000) + 9000000000L),
            userSubjectFirstLetter = String.valueOf(alphabetWithoutSeveralLetters[random.nextInt(alphabetWithoutSeveralLetters.length)]),
            userHobbiesName = Hobbies.values()[userHobbiesDigit - 1].getName(),
            userMonthOfBirth = Month.values()[random.nextInt(Month.values().length)].name(),
            userPicture = "src/test/resources/Kavai.jpg",
            userPictureShortPath = userPicture.replace("src/test/resources/",""),
            userAddress = fakerData.address().fullAddress(),
            userState = randomUtils.selectingState(),
            userCity = randomUtils.selectingCities(userState);
}