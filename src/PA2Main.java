import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class PA2Main {
    public static void main(String[] args) {
        Scanner input = null;
        try {
            input = new Scanner(new File(args[0]));
            HashMap<String, Integer> flights = countDepartures(input);
            ArrayList<String> airportsSorted = new ArrayList<String>(
                    flights.keySet());
            Collections.sort(airportsSorted);
            int check = 0;
            String max = "";
            for (String key : airportsSorted) {
                if (flights.get(key) > check) {
                    check = flights.get(key);
                    max = key;
                }
            }
            System.out.println("MAX FLIGHTS " + check + " : " + max);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        }

    public static HashMap<String, Integer> countDepartures(Scanner input) {

            HashMap<String, Integer> airportToNumFlights = new HashMap<String, Integer>();

            int count = 0;
            while (input.hasNextLine()) {
                String line = input.nextLine();
            String[] details = line.split(",");
                // System.out.println(input.nextLine());
                if (count != 0) {
                    // System.out.println(Arrays.toString(details));
                    if (airportToNumFlights.get(details[2]) == null) {
                        airportToNumFlights.put(details[2], 1);
                    } else {
                        airportToNumFlights.put(details[2],
                                airportToNumFlights.get(details[2]) + 1);
                    }
                if (airportToNumFlights.get(details[4]) == null) {
                    airportToNumFlights.put(details[4], 1);
                } else {
                    airportToNumFlights.put(details[4],
                            airportToNumFlights.get(details[4]) + 1);
                }
                }
                count += 1;
            }
            input.close();

            return airportToNumFlights;
        }

}

