package create;

import model.Apartment;
import model.House;
import model.Summerhouse;
import model.Villa;
import repository.HouseRepository;

public class CreateSampleHouses { // a class for create new objects.

//    HouseRepository houseRepository = new HouseRepository();


    public static void createSampleHouses( HouseRepository houseRepository ){


        houseRepository.addHouse(new Apartment(2000000L, 90, 2, 1));
        houseRepository.addHouse(new Apartment(2500000L, 100, 3, 1));
        houseRepository.addHouse(new Apartment(3000000L, 80, 2, 1));

         houseRepository.addHouse(new Villa(30000000L, 250, 5, 2));
        houseRepository.addHouse(new Villa(35000000L, 300, 6, 3));
        houseRepository.addHouse(new Villa(40000000L, 350, 7, 4));

        houseRepository.addHouse(new Summerhouse(1500000L, 100, 3, 1));
        houseRepository.addHouse(new Summerhouse(1800000L, 120, 4, 1));
        houseRepository.addHouse(new Summerhouse(2000000L, 140, 5, 2));
    }

}
