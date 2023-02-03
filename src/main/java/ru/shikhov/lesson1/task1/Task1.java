package ru.shikhov.lesson1.task1;

public class Task1 {
    public static void main(String[] args) {
        Person person = new Person.Builder()
                .addAddress("ул. Кирова, д.42")
                .addAge(18)
                .addFirstName("Никита")
                .addCountry("РФ")
                .build();
    }
}
