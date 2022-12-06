import java.util.Arrays;
import java.util.Collections;

public class Lab4 {
    public static void main(String[] args) {
            Ship[] warships = new Ship[]{
                new Ship("Yamato", 1941, "Japan", 2500, 256),
                new Ship("Enterprise", 1938, "USA", 2219, 246),
                new Ship("Bismark", 1940, "Germany",2200, 241),
            };

            System.out.println("Sort the array by ship year in ascending order:");
            Arrays.sort(warships, (o1, o2) -> o1.getYear() - o2.getYear());
            for (Ship ship : warships) {
                System.out.println("~~~~~~~~~~~~~~~~\n"+ship);
            }
            System.out.println("~~~~~~~~~~~~~~~~");

            System.out.println("Sort the array by ship name length in descending order:");
            Arrays.sort(warships, Collections.reverseOrder());
            for (Ship ship : warships) {
                System.out.println("~~~~~~~~~~~~~~~~\n"+ship);
            }
            System.out.println("~~~~~~~~~~~~~~~~");
    }
}

class Ship implements Comparable<Ship> {
    private final String name;
    private final int year;
    private final String country;
    private final int crew;
    private final int length;

    public Ship(String name, int year, String country, int crew, int length) {
        this.name = name;
        this.year = year;
        this.country = country;
        this.crew = crew;
        this.length = length;
    }

    public int getYear() {
        return year;
    }

    @Override
    public int compareTo(Ship ship) {
        return this.name.length() - ship.name.length();
    }

    public String toString() {
        return "Ship: " + name + "\nyear: " + year + "\ncountry: " + country
                + "\ncrew: " + crew + "\nlength: " + length;
    }
}