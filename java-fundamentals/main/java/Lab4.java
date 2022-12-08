/*
 * Copyright (c) 2022 Pavlo Baran
 */
import java.util.Arrays;
import java.util.Collections;


/**
 * Lab4 class containing only one method
 * that implements the task of laboratory work 4
 *
 * @author Pavlo Baran
 */
public class Lab4 {
    /**
     * Main method demonstrates the sorting of an array
     * of ships in different ways
     *
     * @param args command-line arguments(ignored)
     */
    public static void main(String[] args) {
        Ship[] warships = new Ship[]{
            new Ship("Yamato", 1941, "Japan", 2500, 256),
            new Ship("Enterprise", 1938, "USA", 2219, 246),
            new Ship("Bismark", 1940, "Germany",2200, 241),
        };

        System.out.println("Sort the array by ship year in ascending order:");
        // Use lambda expression instead new Comparator
        Arrays.sort(warships, (o1, o2) -> o1.getYear() - o2.getYear());
        for (Ship ship : warships) {
            System.out.println("~~~~~~~~~~~~~~~~\n" + ship);
        }
        System.out.println("~~~~~~~~~~~~~~~~");

        System.out.println("Sort the array by ship name length in descending order:");
        Arrays.sort(warships, Collections.reverseOrder());
        for (Ship ship : warships) {
            System.out.println("~~~~~~~~~~~~~~~~\n" + ship);
        }
        System.out.println("~~~~~~~~~~~~~~~~");
    }
}


/**
 * Ship class it`s a simple structure of the ship,
 * implements the Comparable interface
 * and override the compareTo and toString methods
 *
 * @author Pavlo Baran
 */
class Ship implements Comparable<Ship> {
    /** official ship name */
    private final String name;
    /** year of commissioning */
    private final int year;
    /** country of origin */
    private final String country;
    /** number of crew or passengers */
    private final int crew;
    /** full ship length */
    private final int length;

    /**
     * Constructor for creating a new ship
     *
     * @param name official ship name
     * @param year year of commissioning
     * @param country country of origin
     * @param crew number of crew or passengers
     * @param length full ship length
     */
    public Ship(String name, int year, String country, int crew, int length) {
        this.name = name;
        this.year = year;
        this.country = country;
        this.crew = crew;
        this.length = length;
    }

    /**
     * Getter for the ship name
     *
     * @return official ship name
     */
    public int getYear() {
        return year;
    }

    /**
     * Method for comparing two ships by name length
     *
     * @param ship another ship for comparison
     * @return 0 if the ships name length are equal,
     *         else returns the difference in length of ship names in integer
     */
    @Override
    public int compareTo(Ship ship) {
        return this.name.length() - ship.name.length();
    }

    /**
     * Method for converting the ship to a string
     *
     * @return string representation of the ship
     */
    @Override
    public String toString() {
        return "Ship: " + name + "\nyear: " + year + "\ncountry: " + country
                + "\ncrew: " + crew + "\nlength: " + length;
    }
}