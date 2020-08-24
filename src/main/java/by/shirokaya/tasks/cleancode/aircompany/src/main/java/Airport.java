import models.MilitaryType;
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.Plane;
import planes.ExperimentalPlane;

import java.util.*;
import java.util.stream.Collectors;

/**
 * version: 1.1
 * made by Vitali Shulha
 * 4-Jan-2019
 */

public class Airport {

    private final List<? extends Plane> planes;

    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

    public List<PassengerPlane> getPassengerPlanes() {
        List<PassengerPlane> passengerPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof PassengerPlane) {
                passengerPlanes.add((PassengerPlane) plane);
            }
        }
        return passengerPlanes;
    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        List<ExperimentalPlane> experimentalPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof ExperimentalPlane) {
                experimentalPlanes.add((ExperimentalPlane) plane);
            }
        }
        return experimentalPlanes;
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        List<MilitaryPlane> militaryPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof MilitaryPlane) {
                militaryPlanes.add((MilitaryPlane) plane);
            }
        }
        return militaryPlanes;
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        return getPassengerPlanes()
                .stream()
                .max(Comparator.comparing(PassengerPlane::getPassengersCapacity))
                .orElse(null);
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        return filterByMilitaryType(MilitaryType.TRANSPORT);
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        return filterByMilitaryType(MilitaryType.BOMBER);
    }

    private List<MilitaryPlane> filterByMilitaryType(MilitaryType type) {
        return getMilitaryPlanes()
                .stream()
                .filter(p -> p.getMilitaryType().equals(type))
                .collect(Collectors.toList());
    }

    private void sort(List<? extends Plane> planesToSort, Comparator<Plane> comparator) {
        planesToSort.sort(comparator);
    }

    public List<? extends Plane> sortByMaxDistance(List<? extends Plane> planesToSort) {
        Comparator<Plane> comparator = Comparator.comparingInt(Plane::getMaxFlightDistance);
        sort(planesToSort, comparator);
        return planesToSort;
    }

    public List<? extends Plane> sortByMaxSpeed(List<? extends Plane> planesToSort) {
        Comparator<Plane> comparator = Comparator.comparingInt(Plane::getMaxSpeed);
        sort(planesToSort, comparator);
        return planesToSort;
    }

    public List<? extends Plane> sortByMaxLoadCapacity(List<? extends Plane> planesToSort) {
        Comparator<Plane> comparator = Comparator.comparingInt(Plane::getMaxLoadCapacity);
        sort(planesToSort, comparator);
        return planesToSort;
    }

    public List<? extends Plane> getPlanes() {
        return planes;
    }

    public static void print(Collection<? extends Plane> collection) {
        for (Plane plane : collection) {
            System.out.println(plane);
        }
    }

    public static void print(Plane plane) {
        System.out.println(plane.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return Objects.equals(planes, airport.planes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planes);
    }

    @Override
    public String toString() {
        return "Airport{" +
                "Planes=" + planes.toString() +
                '}';
    }
}
