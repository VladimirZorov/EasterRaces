package easterRaces.entities.cars;

import static easterRaces.common.ExceptionMessages.INVALID_HORSE_POWER;

public class MuscleCar extends BaseCar{

    private static final double CUBIC_CENTIMETERS = 5000;
    private int horsePower;

    public MuscleCar(String model, int horsePower) {
        super(model, horsePower,CUBIC_CENTIMETERS);
        this.setHorsePower(horsePower);
    }

    public void setHorsePower(int horsePower) {
        if (horsePower < 400 || horsePower > 600) {
            throw new IllegalArgumentException(String.format(INVALID_HORSE_POWER, horsePower));
        }
        this.horsePower = horsePower;
    }
}
