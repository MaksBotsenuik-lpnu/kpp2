package deliverySystem.Models;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

public class DeliveryCalculator {
    List<Seller> sellers;
    List<DeliveryMethod> deliveryMethods;
    public DeliveryCalculator(List<Seller> sellers, List<DeliveryMethod> deliveryMethods) {
        this.sellers = sellers;
        this.deliveryMethods = deliveryMethods;
    }

    public LocalDate calculateNextBusinessDay(LocalDate orderDate, Seller selectedSeller, DeliveryMethod selectedMethod, deliverySystem.Models.Location store, deliverySystem.Models.Location customer) {
        Duration deliveryTime = selectedMethod.getActualDeliveryTime(orderDate, selectedSeller, store, customer);

        LocalDate proposedDate = orderDate.plusDays(deliveryTime.toDays());

        while (!selectedSeller.isWorkingDay(proposedDate)) {
            proposedDate = proposedDate.plusDays(1);
        }
        return proposedDate;
    }
}
