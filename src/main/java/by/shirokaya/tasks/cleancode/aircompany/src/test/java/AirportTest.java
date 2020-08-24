import models.ClassificationLevel;
import models.ExperimentalType;
import models.MilitaryType;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import planes.ExperimentalPlane;
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.Plane;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AirportTest {
    private final List<Plane> planes = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT),
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ClassificationLevel.SECRET, ExperimentalType.HIGH_ALTITUDE),
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ClassificationLevel.TOP_SECRET, ExperimentalType.VTOL)
    );
    private Airport airport;

    @BeforeClass
    public void setUp() {
        airport = new Airport(planes);
    }

    @Test
    public void testGetTransportMilitaryPlanes() {
        List<MilitaryPlane> expected = Collections.singletonList(
                new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT));
        List<MilitaryPlane> actual = airport.getTransportMilitaryPlanes();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetPassengerPlaneWithMaxPassengerCapacity() {
        PassengerPlane expected =
                new PassengerPlane("Boeing-747", 980, 16100, 70500, 242);
        PassengerPlane actual = airport.getPassengerPlaneWithMaxPassengersCapacity();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSortByMaxLoadCapacity() {
        List<Plane> expected = Arrays.asList(
                new ExperimentalPlane("Bell X-14", 277, 482, 500, ClassificationLevel.SECRET, ExperimentalType.HIGH_ALTITUDE),
                new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ClassificationLevel.TOP_SECRET, ExperimentalType.VTOL),
                new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER),
                new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
                new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
                new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
                new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
                new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT)
                );
        List<? extends Plane> actual = airport.sortByMaxLoadCapacity(planes);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testHasAtLeastOneBomberInMilitaryPlanes() {
        List<MilitaryPlane> bomberMilitaryPlanes = airport.getBomberMilitaryPlanes();
        Assert.assertTrue(bomberMilitaryPlanes.stream()
                .anyMatch(p -> p.getMilitaryType() == MilitaryType.BOMBER));
    }

    @Test
    public void testExperimentalPlanesHasClassificationLevelHigherThanUnclassified() {
        List<ExperimentalPlane> experimentalPlanes = airport.getExperimentalPlanes();
        Assert.assertTrue(experimentalPlanes.stream()
                .noneMatch(p -> p.getClassificationLevel() == ClassificationLevel.UNCLASSIFIED));
    }
}
