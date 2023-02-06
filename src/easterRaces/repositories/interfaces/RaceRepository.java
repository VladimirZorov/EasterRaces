package easterRaces.repositories.interfaces;

import easterRaces.entities.racers.Race;

import java.util.ArrayList;
import java.util.Collection;

public class RaceRepository implements Repository<Race>{

    private Collection<Race> races;

    public RaceRepository() {
        this.races = new ArrayList<>();
    }

    @Override
    public Race getByName(String name) {
        return null;
    }

    @Override
    public Collection<Race> getAll() {
        return null;
    }

    @Override
    public void add(Race model) {

    }

    @Override
    public boolean remove(Race model) {
        return false;
    }
}
