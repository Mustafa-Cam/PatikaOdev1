package repository;
import model.House;

import java.util.ArrayList;
import java.util.List;

public class HouseRepository {

    private final List<House> houses = new ArrayList<>();

    public void addHouse(House house) {
        houses.add(house);
    }

    public List<House> getHouses() {
        return houses;
    }
}
