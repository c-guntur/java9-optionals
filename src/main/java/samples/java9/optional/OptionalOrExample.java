package samples.java9.optional;

import samples.java9.optional.domain.Preference;
import samples.java9.optional.domain.PreferenceFactory;

import java.util.Optional;

public class OptionalOrExample {

    public static void main(String[] args) {
        OptionalOrExample optionalOrExample = new OptionalOrExample();
        optionalOrExample.preJava8Example();
        System.out.println();
        System.out.println();
        optionalOrExample.java8Example();
        System.out.println();
        System.out.println();
        optionalOrExample.java9Example();
    }

    private void preJava8Example() {
        System.out.println("Pre Java 8 --------------------------------- >>>>");

        //Sunny day scenario, creation succeeds in the factory.
        Preference preferenceCreatedInFactoryAfterNotFound = PreferenceFactory.findPreference("AAA");
        if (preferenceCreatedInFactoryAfterNotFound == null) {
            preferenceCreatedInFactoryAfterNotFound =
                    PreferenceFactory.createPreference("AAA", "Top rated preference");
        }
        if (preferenceCreatedInFactoryAfterNotFound == null) {
            preferenceCreatedInFactoryAfterNotFound =
                    new Preference("OOO", "Sledge-hammering creation of AAA");
        }

        //Rainy day scenario, creation fails in the factory.
        Preference preferenceNotCreatedInFactoryAfterNotFound = PreferenceFactory.findPreference("OOO");
        if (preferenceNotCreatedInFactoryAfterNotFound == null) {
            preferenceNotCreatedInFactoryAfterNotFound =
                    PreferenceFactory.createPreference("OOO", "On-the-fly preference");
        }
        if (preferenceNotCreatedInFactoryAfterNotFound == null) {
            preferenceNotCreatedInFactoryAfterNotFound =
                    new Preference("OOO", "Sledge-hammering creation of OOO");
        }

        System.out.println(preferenceCreatedInFactoryAfterNotFound);
        System.out.println(preferenceNotCreatedInFactoryAfterNotFound);
        System.out.println(" <<<< --------------------------------- Pre Java 8");
    }

    private void java8Example() {
        System.out.println("In Java 8 --------------------------------- >>>>");

        //Sunny day scenario, creation succeeds in the factory.
        Preference preferenceCreatedInFactoryAfterNotFound =
                PreferenceFactory
                        .findOptionalPreference("AAA")
                        .orElseGet(PreferenceFactory.getPreferenceSupplier("AAA", "Top rated preference"));
        if (preferenceCreatedInFactoryAfterNotFound == null) {
            preferenceCreatedInFactoryAfterNotFound =
                    new Preference("OOO", "Sledge-hammering creation of AAA");
        }

        //Rainy day scenario, creation fails in the factory.
        Preference preferenceNotCreatedInFactoryAfterNotFound =
                PreferenceFactory
                        .findOptionalPreference("OOO")
                        .orElseGet(PreferenceFactory.getPreferenceSupplier("OOO", "On-the-fly preference"));
        if (preferenceNotCreatedInFactoryAfterNotFound == null) {
            preferenceNotCreatedInFactoryAfterNotFound =
                    new Preference("OOO", "Sledge-hammering creation of OOO");
        }

        System.out.println(preferenceCreatedInFactoryAfterNotFound);
        System.out.println(preferenceNotCreatedInFactoryAfterNotFound);
        System.out.println(" <<<< --------------------------------- In Java 8");
    }

    private void java9Example() {
        System.out.println("In Java 9 --------------------------------- >>>>");

        //Sunny day scenario, creation succeeds in the factory.
        Optional<Preference> preferenceCreatedInFactoryAfterNotFound =
                PreferenceFactory
                        .findOptionalPreference("AAA")
                        .or(PreferenceFactory.getPreferenceOptionalSupplier("AAA", "Top rated preference"));

        //Rainy day scenario, creation fails in the factory.
        Optional<Preference> preferenceNotCreatedInFactoryAfterNotFound =
                PreferenceFactory
                        .findOptionalPreference("OOO")
                        .or(PreferenceFactory.getPreferenceOptionalSupplier("OOO", "On-the-fly preference"));

        System.out.println(preferenceCreatedInFactoryAfterNotFound
                .orElse(new Preference("AAA", "Sledge-hammering creation of AAA")));

        System.out.println(preferenceNotCreatedInFactoryAfterNotFound
                .orElse(new Preference("OOO", "Sledge-hammering creation of OOO")));
        System.out.println(" <<<< --------------------------------- In Java 9");
    }
}
