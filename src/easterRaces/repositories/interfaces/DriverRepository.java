package easterRaces.repositories.interfaces;

import easterRaces.entities.drivers.Driver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DriverRepository implements Repository<Driver>{

    private Collection<Driver> drivers;

    public DriverRepository() {
        this.drivers = new ArrayList<>();
    }

    @Override
    public Driver getByName(String name) {
        for (Driver driver : drivers) {
            if (driver.getName().equals(name)) {
                return driver;
            }
        }
        return null;
    }

    @Override
    public Collection<Driver> getAll() {
        return Collections.unmodifiableCollection(drivers);
    }

    @Override
    public void add(Driver model) {
        boolean driverNameExist = false;
        for (Driver driver : drivers) {
            if (driver.getName().equals(model.getName())) {
                driverNameExist = true;
            }
        }
            if (!driverNameExist) {
                drivers.add(model);
            }
    }

    @Override
    public boolean remove(Driver model) {
        if (drivers.contains(model)) {
            drivers.remove(model);
            return true;
        }
        return false;
    }
}
