package service;


import create.CreateSampleHouses;
import model.Apartment;
import model.House;
import model.Villa;
import model.Summerhouse;
import repository.HouseRepository;

import java.util.List;
import java.util.stream.Collectors;

public class HouseService {
    private final HouseRepository houseRepository = new HouseRepository(); // Since the HouseRepository class is public, we create an object.

//    public void createSampleHouses() {
//        houseRepository.addHouse(new Villa(300000, 250, 5, 2));
//        houseRepository.addHouse(new Villa(350000, 300, 6, 3));
//        houseRepository.addHouse(new Villa(400000, 350, 7, 4));
//
//        houseRepository.addHouse(new Summerhouse(150000, 100, 3, 1));
//        houseRepository.addHouse(new Summerhouse(180000, 120, 4, 1));
//        houseRepository.addHouse(new Summerhouse(200000, 140, 5, 2));
//    }



    public HouseService(){
        CreateSampleHouses.createSampleHouses(houseRepository); // Since the createSampleHouses method is static, we can call it without creating an object. we create the new objects. if we dont description the this code we dont use the new created objects.
    }

    public Long getTotalPriceOfVillas() {
        return houseRepository.getHouses().stream()
                .filter(house -> house instanceof Villa) //burda gethouse ile tüm kayıtları getiriyoruz ancak kalıtım olan ev türleri var yani villa, yaz evi gibi instanceof operatörü ise bu örneğin hangi türe ait olduğunu kontrol etmek için kullanılıyor. filtrelemede çok işimize yarıyor o yüzden. Kısaca inheritance konusunda kullanılıyor.
                .mapToLong(House::getPrice)
                .sum();
    }

    public double getTotalPriceOfSummerhouses() {
        return houseRepository.getHouses().stream()
                .filter(house -> house instanceof Summerhouse)
                .mapToDouble(House::getPrice)
                .sum();
    }
    public double getTotalPriceOfApartment() {
        return houseRepository.getHouses().stream()
                .filter(house -> house instanceof Apartment)
                .mapToDouble(House::getPrice)
                .sum();
    }

    public Long getTotalPriceOfAllHouses() {
        return houseRepository.getHouses().stream()
                .mapToLong(House::getPrice)
                .sum();
    }


    public double getAverageSquareMetersOfApartment() {
        return houseRepository.getHouses().stream()
                .filter(house -> house instanceof Apartment)
                .mapToDouble(House::getSquareMeters) //mapToDouble fonksiyonu ise dönüşüm sağlıyor burda double türüne dönüştürülmüş.
                .average()
                .orElse(0);
    }

    public double getAverageSquareMetersOfVillas() {
        return houseRepository.getHouses().stream()
                .filter(house -> house instanceof Villa)
                .mapToDouble(House::getSquareMeters)
                .average()
                .orElse(0);
    }

    public double getAverageSquareMetersOfSummerhouses() {
        return houseRepository.getHouses().stream()
                .filter(house -> house instanceof Summerhouse)
                .mapToDouble(House::getSquareMeters)
                .average()
                .orElse(0);
    }

    public double getAverageSquareMetersOfAllHouses() {
        return houseRepository.getHouses().stream()
                .mapToDouble(House::getSquareMeters)
                .average()
                .orElse(0);
    }

    public List<House> filterHousesByRoomAndLivingRoom(int numberOfRooms, int numberOfLivingRooms) {
        return houseRepository.getHouses().stream()
                .filter(house -> house.getNumberOfRooms() == numberOfRooms && house.getNumberOfLivingRooms() == numberOfLivingRooms)
                .collect(Collectors.toList());
    }

}

