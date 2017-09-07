package samples.java9.optional.domain;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;

public class PreferenceFactory {
    public static Set<String> PREFERENCE_NAMES = new HashSet<>();

    static {
        PREFERENCE_NAMES.add("ABC");
        PREFERENCE_NAMES.add("DEF");
        PREFERENCE_NAMES.add("XYZ");
        PREFERENCE_NAMES.add("ZZZ");
    }

    public static Preference findPreference(String name) {
        Preference preference = null;
        switch (name) {
            case "ABC":
                preference = new Preference("ABC", "01_02_03");
                break;
            case "DEF":
                preference = new Preference("DEF", "04_05_06");
                break;
            case "XYZ":
                preference = new Preference("XYZ", "24_25_26");
                break;
        }
        return preference;
    }

    public static Optional<Preference> findOptionalPreference(String name) {
        Optional<Preference> preference = Optional.empty();
        switch (name) {
            case "ABC":
                preference = Optional.of(new Preference("ABC", "01_02_03"));
                break;
            case "DEF":
                preference = Optional.of(new Preference("DEF", "04_05_06"));
                break;
            case "XYZ":
                preference = Optional.of(new Preference("XYZ", "24_25_26"));
                break;
        }
        return preference;
    }

    public static Preference createPreference(String name, String description) {
        if("OOO".equalsIgnoreCase(name)) {
            // Fake case of creation failure
            return null;
        } else {
            return new Preference(name, description);
        }
    }

    public static Supplier<Preference> getPreferenceSupplier(String name, String description) {
        if("OOO".equalsIgnoreCase(name)) {
            return () -> null;
        }
        return () -> new Preference(name, description);
    }
    public static Supplier<Optional<Preference>> getPreferenceOptionalSupplier(String name, String description) {
        if("OOO".equalsIgnoreCase(name)) {
            return () -> Optional.empty();
        }
        return () -> Optional.of(new Preference(name, description));
    }
}
