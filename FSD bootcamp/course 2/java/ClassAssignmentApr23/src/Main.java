import java.util.Scanner;

public class Main {

    public static void displayTouristData(double[][] touristData, String[] cities) {
        System.out.println("===== TOURIST ATTRACTIONS MANAGEMENT SYSTEM =====");
        System.out.println("\nCity        Attractions   Rating(1-10)   Avg Fee($)");
        System.out.println("----------------------------------------------------");
        for (int i = 0; i < cities.length; i++) {
            System.out.print(cities[i]);
            for (int j = 0; j < touristData[i].length; j++) {
                if (j==1) {
                    System.out.print("\t\t\t\t" + touristData[i][j]);
                }
                else {
                    System.out.print("\t\t\t" + (int) touristData[i][j]);
                }
            }
            System.out.println(" ");
        }
    }

    record Result(double[] cityData, int cityIndex) {}

    public  static Result findCityWithLeastAttractions(double[][] touristData) {
        Result returnVal;
        double noOfAttractions =30;
        double[] cityData = new double[3];
        int cityIndex = 0;
        for (int i = 0; i < touristData.length; i++) {
            if(touristData[i][0] < noOfAttractions) {
               noOfAttractions = touristData[i][0];
               cityData = touristData[i];
               cityIndex = i;
            }
        }
        returnVal = new Result(cityData, cityIndex);
        return returnVal;
    }

    public static void main(String[] args) {

        String[] cities = {"Paris", "Rome", "Tokyo", "NewYork", "Cairo" };
        Scanner scanner= new Scanner(System.in);
        double[][] touristData = {
                {8,9.5,15.0},
                {7,9.2,12.0},
                {10,8.9,20.0},
                {9,8.5,25.0},
                {6,8.0,8.0},
        };
        displayTouristData(touristData, cities);

        System.out.println("\n\n===== MENU =====");
        System.out.println("1. View city information by index (0-4)");
        System.out.println("2. Show cities above rating threshold");
        System.out.println("3. Find cheapest city to visit");
        System.out.println("4. Sort cities by number of attractions");
        System.out.println("5. Exit");

        System.out.print("\n\nEnter your choice:");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter city index (0-4):");
                int cityIndex = scanner.nextInt();
                System.out.println("City: " + cities[cityIndex]);
                System.out.println("Number of attractions: " + (int)touristData[cityIndex][0]);
                System.out.println("Average Rating: " + touristData[cityIndex][1]);
                System.out.println("Average Entrance Fee: " + (int)touristData[cityIndex][2]);
                break;
            case 2:
                System.out.print("Enter rating threshold:");
                double ratingThreshold = scanner.nextDouble();
                System.out.println("Cities with rating threshold > " + ratingThreshold );
                for (int i = 0; i < cities.length; i++) {
                    if (touristData[i][1] > ratingThreshold) {
                        System.out.println(cities[i]);
                    }
                }
                break;
            case 3:
                int cost = 40;
                String cheapestCity = "";
                for (int i = 0; i < cities.length; i++) {
                    if(touristData[i][2] < cost) {
                        cost = (int) touristData[i][2];
                        cheapestCity = cities[i];
                    }
                }
                System.out.println("The cheapest city ot visit is: " + cheapestCity);
                break;
            case 4:
                String[] sortedCities = new String[cities.length];
                double[][] sortedTouristData = new double[cities.length][3];
                double[][] tmpTouristData = new double[cities.length][3];
                for (int k=0; k<tmpTouristData.length; k++){
                    tmpTouristData[k] = touristData[k];
                }
                for(int i = 0; i < cities.length; i++) {
                    Result result = findCityWithLeastAttractions(tmpTouristData);
                    sortedCities[i] = cities[result.cityIndex];
                    sortedTouristData[i] = result.cityData;
                    if(i<=cities.length-2) {
                        tmpTouristData = new double[cities.length- i-1][3];
                        for (int j = 0; j < touristData.length; j++) {
                            for (int k=0; k<sortedTouristData[j].length; k++) {
                                if (touristData[j][0] != sortedTouristData[k][0] && sortedTouristData[k][0] != 0) {
                                    tmpTouristData[j] = touristData[j];
                                }
                            }
                        }
                    }
                }
                displayTouristData(sortedTouristData,sortedCities);
        }

    }
}