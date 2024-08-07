package utils;

import com.github.javafaker.Faker;

public class FakerUtils {
    public static String generateName() {
        Faker faker = new Faker();
        return "Playlist " + faker.number().digits(8);
    }

    public static String generateDescription() {
        Faker faker = new Faker();
        return faker.rickAndMorty().quote();
    }

    public static String generateRandomDate() {
        Faker faker = new Faker();
        return faker.date().toString();
    }
}
