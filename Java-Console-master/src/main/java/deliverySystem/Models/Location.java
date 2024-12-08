package deliverySystem.Models;


import java.time.ZoneId;

public class Location {
    private String address;
    private ZoneId timeZone;

    public Location(String address, ZoneId timeZone) {
        this.address = address;
        this.timeZone = timeZone;
    }

    public ZoneId getTimeZone() {
        return this.timeZone;
    }
}