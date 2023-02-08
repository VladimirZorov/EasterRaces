package easterRaces.repositories.interfaces;

import easterRaces.entities.cars.Car;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CarRepository implements Repository<Car>{

    private Collection<Car> cars;

    public CarRepository() {
        this.cars = new ArrayList<>();
    }

    @Override
    public Car getByName(String name) {
        for (Car car : cars) {
            if (car.getModel().equals(name)) {
                return car;
            }
        }
        return null;
    }

    @Override
    public Collection<Car> getAll() {
        return Collections.unmodifiableCollection(cars);
    }

    @Override
    public void add(Car model) {
        cars.add(model);
    }

    @Override
    public boolean remove(Car model) {
        if (cars.contains(model)){
            cars.remove(model);
            return true;
        }
        return false;
    }
}
