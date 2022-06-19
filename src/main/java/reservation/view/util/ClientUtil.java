package reservation.view.util;

import reservation.controller.location.LocationController;
import reservation.model.location.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ClientUtil {


    public static <T> Optional<T> read(List<T> list) {
        Optional<T> result = Optional.empty();
        if (list.isEmpty())
            return result;

        print(list);

        System.out.println("Please select from available options (1, 2, 3, 4 ..etc)");
        while (!result.isPresent()) {
            Scanner sc = new Scanner(System.in);
            int select = sc.nextInt();
            if (select < 1 || select > list.size()) {
                System.out.println("Invalid selection, please select valid option");
                continue;
            }
            result = Optional.ofNullable(list.get(select - 1));
        }
        return result;
    }

    public static <T> void print (List<T> list) {
        list.stream().forEach((item) -> {
            System.out.println(item.toString());
        });
    }

    public static Optional<String> readText() {
        Optional<String> result = Optional.empty();
        while (!result.isPresent()) {
            String searchTerm = readText2();
            if (searchTerm == null || searchTerm.trim().equals("")) {
                System.out.println("Invalid input, please enter valid text");
            } else {
                result = Optional.of(searchTerm);
            }
        }
        return result;
    }

    public static int readInt(int maxValue) {
        int value = 0;
        while (value == 0) {
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            if (input == 0 || input > maxValue) {
                System.out.println("Invalid input, please select proper option");
            } else {
                value = input;
            }
        }
        return value;
    }


    private static String readText2() {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.next();
        return text;
    }

    public static List<Location> filterLocations(LocationController locationController) {
        List<Location> locations = new ArrayList<>();
        while (locations.size() == 0) {
            Optional<String> searchTerm = ClientUtil.readText();
            locations = locationController.filterLocations(searchTerm);
            if (locations.size() == 0) {
                System.out.println("No locations found, try again with valid location");
            }
        }
        return locations;
    }
}
