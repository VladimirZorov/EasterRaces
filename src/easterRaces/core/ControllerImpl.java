package easterRaces.core;

import easterRaces.core.interfaces.Controller;
import easterRaces.entities.cars.Car;
import easterRaces.entities.drivers.Driver;
import easterRaces.entities.drivers.DriverImpl;
import easterRaces.repositories.interfaces.CarRepository;
import easterRaces.repositories.interfaces.DriverRepository;
import easterRaces.repositories.interfaces.RaceRepository;

import static easterRaces.common.ExceptionMessages.DRIVER_EXISTS;
import static easterRaces.common.OutputMessages.DRIVER_CREATED;

public class ControllerImpl implements Controller {

    private CarRepository carRepository;
    private DriverRepository driverRepository;
    private RaceRepository raceRepository;



    public ControllerImpl() {
        this.carRepository = new CarRepository();
        this.driverRepository = new DriverRepository();
        this.raceRepository = new RaceRepository();
    }

    @Override
    public String createDriver(String driver) {
         boolean driverExist = false;
        for (Driver driver1 : driverRepository.getAll()) {
            if (driver1.getName().equals(driver)) {
                driverExist = true;
            }
            if (!driverExist) {
                Driver driver2 = new DriverImpl(driver);
                driverRepository.add(driver2);
            } else {
                throw new IllegalArgumentException(String.format(DRIVER_EXISTS, driver));
            }
        }
        return String.format(DRIVER_CREATED, driver);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {

        return null;
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        return null;
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        return null;
    }

    @Override
    public String startRace(String raceName) {
        return null;
    }

    @Override
    public String createRace(String name, int laps) {
        return null;
    }
}
