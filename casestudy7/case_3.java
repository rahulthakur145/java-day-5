package casestudy7;

import java.util.*;

abstract class Transport {
    String trackingId;
    String destination;

    Transport(String trackingId, String destination) {
        this.trackingId = trackingId;
        this.destination = destination;
    }

    abstract void dispatch();
}

interface GPS {
    void getCoordinates();

    default void pingServer() {
        System.out.println("Status: Online...");
    }
}

interface Autonomous {
    void selfNavigate();
}

class DeliveryDrone extends Transport implements GPS, Autonomous {
    DeliveryDrone(String trackingId, String destination) {
        super(trackingId, destination);
    }

    @Override
    void dispatch() {
        System.out.println("Drone " + trackingId + " taking off...");
    }

    @Override
    public void getCoordinates() {
        System.out.println("40.7128° N...");
    }

    @Override
    public void selfNavigate() {
        System.out.println("Drone " + trackingId + " navigating autonomously...");
    }
}

class Truck extends Transport {
    Truck(String trackingId, String destination) {
        super(trackingId, destination);
    }

    @Override
    void dispatch() {
        System.out.println("Truck " + trackingId + " starting delivery...");
    }
}

class CargoShip extends Transport implements GPS {
    CargoShip(String trackingId, String destination) {
        super(trackingId, destination);
    }

    @Override
    void dispatch() {
        System.out.println("Cargo Ship " + trackingId + " departing...");
    }

    @Override
    public void getCoordinates() {
        System.out.println("25.7617° N...");
    }
}

public class case_3 {
    public static void main(String[] args) {
        Transport t = new DeliveryDrone("D101", "NYC");
        t.dispatch();

        GPS g = new DeliveryDrone("D102", "LA");
        g.pingServer();

        List<Transport> list = new ArrayList<>();
        list.add(new DeliveryDrone("D103", "Chicago"));
        list.add(new Truck("T201", "Dallas"));
        list.add(new CargoShip("S301", "Miami"));

        for (Transport tr : list) {
            tr.dispatch();

            if (tr instanceof GPS) {
                GPS gps = (GPS) tr;
                gps.getCoordinates();
                gps.pingServer();
            }

            if (tr instanceof Autonomous) {
                Autonomous auto = (Autonomous) tr;
                auto.selfNavigate();
            }
        }
    }
}