package guru.qa.enumvalues;

public enum States {
    NCR("NCR"),
    UTTAR("Uttar Pradesh"),
    HARYANA("Haryana"),
    RAJASTHAN("Rajasthan");

    private String name;

    States(String nameOfState) {
        name = nameOfState;
    }

    public String getName() {
        return name;
    }
}
