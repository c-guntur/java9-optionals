package samples.java9.optional.domain;

public class Preference {
    private String name;
    private String description;

    public Preference(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Preference{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}
