package planes;

import models.ClassificationLevel;
import models.ExperimentalType;
import models.MilitaryType;

public class MilitaryPlane extends Plane {

    public MilitaryPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, MilitaryType militaryType) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity, ClassificationLevel.NONE, ExperimentalType.NONE, militaryType);
    }

}




