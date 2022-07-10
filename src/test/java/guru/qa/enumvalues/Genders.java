package guru.qa.enumvalues;

public enum Genders {
    MALE("Male"),
    FEMALE("Female"),
    OTHER("Other");

    private String name;

    Genders(String nameOfGender) {
        name = nameOfGender;
    }

    public String getName() {
        return name;
    }
}
