package planes;

import models.ClassificationLevel;
import models.ExperimentalType;
import models.MilitaryType;

public class ExperimentalPlane extends Plane {

    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, ClassificationLevel classificationLevel, ExperimentalType experimentalType) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity, classificationLevel, experimentalType, MilitaryType.NONE);
    }

}
