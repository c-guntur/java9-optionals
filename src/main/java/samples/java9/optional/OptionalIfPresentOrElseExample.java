package samples.java9.optional;

import samples.java9.optional.domain.Preference;
import samples.java9.optional.domain.PreferenceFactory;

import java.util.Optional;

public class OptionalIfPresentOrElseExample {

    public static void main(String[] args) {
        OptionalIfPresentOrElseExample optionalIfPresentOrElseExample = new OptionalIfPresentOrElseExample();
        optionalIfPresentOrElseExample.preJava8Example();
        System.out.println();
        System.out.println();
        optionalIfPresentOrElseExample.java8Example();
        System.out.println();
        System.out.println();
        optionalIfPresentOrElseExample.java9Example();
    }

    private void preJava8Example() {
        System.out.println("Pre Java 8 --------------------------------- >>>>");

        Preference preferenceABC = PreferenceFactory.findPreference("ABC");
        if(preferenceABC != null) {
            System.out.println("Preference ABC exists");
        } else {
            System.out.println("Preference ABC does not exist");
        }

        Preference preferenceOOO = PreferenceFactory.findPreference("OOO");
        if(preferenceOOO != null) {
            System.out.println("Preference OOO exists");
        } else {
            System.out.println("Preference OOO does not exist");
        }

        System.out.println(" <<<< --------------------------------- Pre Java 8");
    }

    private void java8Example() {
        System.out.println("In Java 8 --------------------------------- >>>>");

        Optional<Preference> optionalPreferenceABC = PreferenceFactory.findOptionalPreference("ABC");

        optionalPreferenceABC.ifPresent(preference -> System.out.println("Preference ABC exists"));
        if( ! optionalPreferenceABC.isPresent() ) {
            System.out.println("Preference ABC does not exist");
        }

        Optional<Preference> optionalPreferenceOOO = PreferenceFactory.findOptionalPreference("OOO");

        optionalPreferenceOOO.ifPresent(preference -> System.out.println("Preference OOO exists"));
        if( ! optionalPreferenceOOO.isPresent() ) {
            System.out.println("Preference OOO does not exist");
        }

        System.out.println(" <<<< --------------------------------- In Java 8");
    }

    private void java9Example() {
        System.out.println("In Java 9 --------------------------------- >>>>");

        Optional<Preference> optionalPreferenceABC = PreferenceFactory.findOptionalPreference("ABC");

        optionalPreferenceABC.ifPresentOrElse(
                preference -> System.out.println("Preference ABC exists"),
                () -> System.out.println("Preference ABC does not exist"));

        Optional<Preference> optionalPreferenceOOO = PreferenceFactory.findOptionalPreference("OOO");

        optionalPreferenceOOO.ifPresentOrElse(
                preference -> System.out.println("Preference OOO exists"),
                () -> System.out.println("Preference OOO does not exist"));

        System.out.println(" <<<< --------------------------------- In Java 9");
    }
}
