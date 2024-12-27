//Project no.2 of CodeAlpha
import java.util.*;

public class TravelPlanner {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("--- Travel Planner ---\n");
        List<TravelDestination> travelPlan = new ArrayList<>();

        boolean addingDestinations = true;
        while (addingDestinations) {
            // Input destination
            System.out.print("Enter destination: ");
            String destination = scanner.nextLine();

            // Input travel date
            System.out.print("Enter travel date (yyyy-mm-dd): ");
            String date = scanner.nextLine();

            // Input preferences
            System.out.println("Enter your preferences:");
            System.out.print("- Preferred mode of transport: ");
            String transport = scanner.nextLine();
            System.out.print("- Accommodation type: ");
            String accommodation = scanner.nextLine();
            System.out.print("- Estimated budget (USD): ");
            double budget = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            // Add destination details to the plan
            travelPlan.add(new TravelDestination(destination, date, transport, accommodation, budget));

            // Ask if the user wants to add another destination
            System.out.print("Do you want to add another destination? (yes/no): ");
            String response = scanner.nextLine();
            if (!response.equalsIgnoreCase("yes")) {
                addingDestinations = false;
            }
        }

        // Display travel plan
        System.out.println("\n--- Your Travel Plan ---\n");
        double totalBudget = 0;
        for (TravelDestination td : travelPlan) {
            System.out.println(td);
            totalBudget += td.getBudget();
        }

        System.out.println("\nTotal Estimated Budget: " + totalBudget + " USD");
        System.out.println("\nThank you for using the Travel Planner!");
    }
}

// Class to represent a travel destination
class TravelDestination {
    private String destination;
    private String date;
    private String transport;
    private String accommodation;
    private double budget;

    public TravelDestination(String destination, String date, String transport, String accommodation, double budget) {
        this.destination = destination;
        this.date = date;
        this.transport = transport;
        this.accommodation = accommodation;
        this.budget = budget;
    }

    public double getBudget() {
        return budget;
    }

    @Override
    public String toString() {
        return "Destination: " + destination + "\n" +
                "Date: " + date + "\n" +
                "Transport: " + transport + "\n" +
                "Accommodation: " + accommodation + "\n" +
                "Budget: " + budget + " USD";
    }
}
