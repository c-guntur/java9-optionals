package samples.java9.optional;

import samples.java9.optional.domain.Preference;
import samples.java9.optional.domain.PreferenceFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OptionalStreamExample {

    public static void main(String... args) {
        OptionalStreamExample preferences = new OptionalStreamExample();
        preferences.preJava8Example();
        System.out.println();
        System.out.println();
        preferences.java8Example();
        System.out.println();
        System.out.println();
        preferences.java9Example();
    }

    private void preJava8Example() {
        List<Preference> preferences = new ArrayList<>();
        for (String preferenceName : PreferenceFactory.PREFERENCE_NAMES) {
            Preference aPreference = PreferenceFactory.findPreference(preferenceName);
            if (aPreference != null) {
                preferences.add(aPreference);
            }
        }
        System.out.println("Pre Java 8 --------------------------------- >>>>");
        preferences.forEach(System.out::println);
        System.out.println(" <<<< --------------------------------- Pre Java 8");
    }

    private void java8Example() {
        List<Preference> preferences =
                PreferenceFactory.PREFERENCE_NAMES.stream()
                        .map(PreferenceFactory::findOptionalPreference)
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .collect(Collectors.toList());
        System.out.println("In Java 8 --------------------------------- >>>>");
        preferences.forEach(System.out::println);
        System.out.println(" <<<< --------------------------------- In Java 8");
    }

    private void java9Example() {
        List<Preference> preferences =
                PreferenceFactory.PREFERENCE_NAMES.stream()
                        .map(PreferenceFactory::findOptionalPreference)
                        .flatMap(Optional::stream)
                        .collect(Collectors.toList());
        System.out.println("In Java 9 --------------------------------- >>>>");
        preferences.forEach(System.out::println);
        System.out.println(" <<<< --------------------------------- In Java 9");
    }
}
