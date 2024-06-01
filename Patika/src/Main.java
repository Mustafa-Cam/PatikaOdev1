

import model.Villa;
import model.Summerhouse;
import service.HouseService;

public class Main {
    public static void main(String[] args) {
        HouseService houseService = new HouseService();

        System.out.println("Total price of villas: " + houseService.getTotalPriceOfVillas()+" TL");
        System.out.println("Total price of summerhouses: " + houseService.getTotalPriceOfSummerhouses()+" TL");
        System.out.println("Total price of Apartment: " + houseService.getTotalPriceOfApartment()+" TL");
        System.out.println("Total price of all houses: " + houseService.getTotalPriceOfAllHouses()+" TL");

        System.out.println("Average square meters of houses: " + houseService.getAverageSquareMetersOfApartment()+" TL");
        System.out.println("Average square meters of villas: " + houseService.getAverageSquareMetersOfVillas()+" TL");
        System.out.println("Average square meters of summerhouses: " + houseService.getAverageSquareMetersOfSummerhouses()+" TL");
        System.out.println("Average square meters of all houses: " + houseService.getAverageSquareMetersOfAllHouses()+" TL");

        System.out.println("Houses with 3 rooms and 1 living room: " + houseService.filterHousesByRoomAndLivingRoom(3, 1));
    }
}
