package easterRaces.core;

import easterRaces.core.interfaces.Controller;
import easterRaces.entities.cars.Car;
import easterRaces.entities.cars.MuscleCar;
import easterRaces.entities.cars.SportsCar;
import easterRaces.entities.drivers.Driver;
import easterRaces.entities.drivers.DriverImpl;
import easterRaces.entities.racers.Race;
import easterRaces.entities.racers.RaceImpl;
import easterRaces.repositories.interfaces.CarRepository;
import easterRaces.repositories.interfaces.DriverRepository;
import easterRaces.repositories.interfaces.RaceRepository;

import static easterRaces.common.ExceptionMessages.*;
import static easterRaces.common.OutputMessages.*;

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
         Driver driver1 = new DriverImpl(driver);
        for (Driver driver2 : driverRepository.getAll()) {
            if (driver2.getName().equals(driver1.getName())) {
                driverExist = true;
            }
        }
            if (driverExist) {
                throw new IllegalArgumentException(String.format(DRIVER_EXISTS, driver));
            }
       driverRepository.add(driver1);
        return String.format(DRIVER_CREATED, driver);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        Car car = null;
        boolean carExist = false;
        if (type.equals("Muscle")) {
            car = new MuscleCar(model, horsePower);
            for(Car car1 : carRepository.getAll()) {
                if (car1.getModel().equals(car.getModel())) {
                    throw new IllegalArgumentException(String.format(CAR_EXISTS, model));
                }
            }
        } else if (type.equals("Sports")) {
            car = new SportsCar(model, horsePower);
            for(Car car1 : carRepository.getAll()) {
                if (car1.getModel().equals(car.getModel())) {
                    throw new IllegalArgumentException(String.format(CAR_EXISTS, model));
                }
            }
        }
            carRepository.add(car);
        return String.format(CAR_CREATED, type+"Car", model);
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        Driver driver = null;
        Car car = null;
       boolean driverExist = false;
       boolean carExist = false;
        for (Driver driver1 : driverRepository.getAll()){
            if (driver1.getName().equals(driverName)) {
                driver = driver1;
                driverExist = true;
            }
        }
        for (Car car1 : carRepository.getAll()) {
            if (car1.getModel().equals(carModel)) {
                car = car1;
                carExist = true;
            }
        }
        if (driverExist && carExist){
            driver.addCar(car);
        } else if (driverExist && !carExist) {
            throw new IllegalArgumentException(String.format(CAR_NOT_FOUND, carModel));
        } else if (!driverExist && carExist) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));
        }
        return String.format(CAR_ADDED, driverName, carModel);
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
        Race race = new RaceImpl(name, laps);
        if (raceRepository.getAll().contains(race)) {
            throw new IllegalArgumentException(String.format(RACE_EXISTS, name));
        }
        raceRepository.add(race);
        return String.format(RACE_CREATED, name);
    }
}
