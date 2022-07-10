package guru.qa.enumvalues;

public enum Hobbies {
    SPORTS("Sports"),
    READING("Reading"),
    MUSIC("Music");

    private String name;

    Hobbies(String nameOfSport) {
        name = nameOfSport;
    }

    public String getName() {
        return name;
    }
}
