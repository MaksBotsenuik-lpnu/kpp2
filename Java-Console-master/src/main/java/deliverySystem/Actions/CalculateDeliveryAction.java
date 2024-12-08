package deliverySystem.Actions;

import deliverySystem.Models.DeliveryCalculator;
import deliverySystem.Models.DeliveryMethod;
import deliverySystem.Models.Seller;
import deliverySystem.Models.Location;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Scanner;

public class CalculateDeliveryAction implements Action {
    private final List<Seller> sellers;
    private final List<DeliveryMethod> deliveryMethods;
    private final Scanner scanner;

    public CalculateDeliveryAction(List<Seller> sellers, List<DeliveryMethod> deliveryMethods, Scanner scanner) {
        this.sellers = sellers;
        this.deliveryMethods = deliveryMethods;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("Enter the order date (YYYY-MM-DD):");
        LocalDate orderDate = LocalDate.parse(scanner.nextLine());
        System.out.println("Choose a seller:");

        Seller selectedSeller = sellers.get(0);
        System.out.println("Choose a delivery method:");

        DeliveryMethod selectedMethod = deliveryMethods.get(0);

        DeliveryCalculator calculator = new DeliveryCalculator(sellers, deliveryMethods);
        LocalDate deliveryDate = calculator.calculateNextBusinessDay(orderDate, selectedSeller, selectedMethod,
                new Location("Store", selectedSeller.getTimeZone()),
                new Location("Customer", ZoneId.systemDefault()));
        System.out.println("Estimated delivery date: " + deliveryDate);
    }
}