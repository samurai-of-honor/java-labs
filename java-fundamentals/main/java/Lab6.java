/*
 * Copyright (c) 2022 Pavlo Baran
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lab6 {
    public static void main(String[] args) {
        WashingMachine washingMachine = new WashingMachine();
        VacuumCleaner vacuumCleaner = new VacuumCleaner();
        Refrigerator refrigerator = new Refrigerator();
        Microwave microwave = new Microwave();
        Blender blender = new Blender();

        List<ElectricalAppliances> appliances = new ArrayList<>() {{
            add(washingMachine);
            add(refrigerator);
            add(microwave);
            add(blender);
        }};
        ElectricalNetwork network = new ElectricalNetwork(appliances);

        refrigerator.turnOn();
        blender.turnOn();
        washingMachine.turnOn();

        System.out.println("Current power consumption: " + network.getCurrentPowerConsumption());

        network.addAppliance(vacuumCleaner);
        network.removeAppliance(blender);
        washingMachine.turnOff();

        System.out.println("\nAppliance sorted by power:");
        network.sortByPower();
        network.printAppliances();

        List<ElectricalAppliances> foundAppliances = network.searchByPowerInterval(400, 200);
        System.out.println("\nAppliances in 200w-400w interval:");
        for (ElectricalAppliances appliance : foundAppliances) {
            System.out.println(appliance);
        }
    }
}

/**
 * ElectricalNetwork class simulate a real electrical network.
 * Class accept a list of connected electrical appliances.
 */
class ElectricalNetwork {
    private final List<ElectricalAppliances> elAppliances;

    public ElectricalNetwork(List<ElectricalAppliances> elAppliances) {
        this.elAppliances = elAppliances;
    }

    public void addAppliance(ElectricalAppliances elAppliance) {
        elAppliances.add(elAppliance);
    }

    public void removeAppliance(ElectricalAppliances elAppliance) {
        elAppliances.remove(elAppliance);
    }

    /**
     * Method return power consumption of all connected and turned on appliances
     *
     * @return current power consumption
     */
    public int getCurrentPowerConsumption() {
        int currentConsumption = 0;

        for (ElectricalAppliances elAppliance : elAppliances) {
            if (elAppliance.isTurnedOn()) {
                currentConsumption += elAppliance.getPower();
            }
        }
        return currentConsumption;
    }

    public void sortByPower() {
        elAppliances.sort(Comparator.comparingInt(ElectricalAppliances::getPower));
    }

    /**
     * Method return list of appliances with power in specified interval.
     * If interval is reversed, swaps minPower and maxPower.
     *
     * @param minPower minimum required power
     * @param maxPower maximum required power
     * @return list of appliances or empty list if no appliances found
     */
    public List<ElectricalAppliances> searchByPowerInterval(int minPower, int maxPower) {
        List<ElectricalAppliances> appliances = new ArrayList<>();

        if (minPower > maxPower) {
            minPower += maxPower;
            maxPower = minPower - maxPower;
            minPower -= maxPower;
//            int temp = minPower;
//            minPower = maxPower;
//            maxPower = temp;
        }

        for (ElectricalAppliances elAppliance : elAppliances) {
            int appPower = elAppliance.getPower();
            if (appPower >= minPower && appPower <= maxPower) {
                appliances.add(elAppliance);
            }
        }
        return appliances;
    }

    public void printAppliances() {
        for (ElectricalAppliances elAppliance : elAppliances) {
            System.out.println(elAppliance);
        }
    }
}

/**
 * ElectricalAppliances class is a base abstract class for all electrical appliances.
 * Class contains power consumption and state of appliance.
 * Class contains methods for turning on and off appliance.
 * Class overrides toString method for printing appliance info.
 */
abstract class ElectricalAppliances {
    private final int power;
    private boolean isTurnedOn;

    public ElectricalAppliances(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public boolean isTurnedOn() {
        return isTurnedOn;
    }

    public void turnOn() {
        isTurnedOn = true;
    }

    public void turnOff() {
        isTurnedOn = false;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " {\n" +
                "\tpower = " + power +
                "\n\tisTurnedOn = " + isTurnedOn + " }";
    }
}

abstract class HomeAppliances extends ElectricalAppliances {
    public HomeAppliances(int power) {
        super(power);
    }
}

class WashingMachine extends HomeAppliances {
    static final int WASHING_MACHINE_POWER = 2400;
    public WashingMachine() {
        super(WASHING_MACHINE_POWER);
    }
}

// Magic number?
class VacuumCleaner extends HomeAppliances {
    public VacuumCleaner() {
        super(350);
    }
}

abstract class KitchenAppliances extends HomeAppliances {
    public KitchenAppliances(int power) {
        super(power);
    }
}

class Refrigerator extends KitchenAppliances {
    public Refrigerator() {
        super(200);
    }
}

class Microwave extends KitchenAppliances {
    public Microwave() {
        super(1000);
    }
}

class Blender extends KitchenAppliances {
    public Blender() {
        super(500);
    }
}