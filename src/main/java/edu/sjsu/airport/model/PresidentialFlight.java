package edu.sjsu.airport.model;
import java.time.LocalDateTime;
import edu.sjsu.airport.exception.InvalidTravelDocumentException;

public class PresidentialFlight extends Flight{
    Passenger trump = new Passenger("007", "Donald J. Trump", "Big Bird", 
    "676767", true);
    private static final int REQUIRED_ARRIVAL_MINUTES = 180;

    public PresidentialFlight(
            String flightNumber,
            String origin,
            String destination,
            LocalDateTime departureTime,
            LocalDateTime arrivalTime,
            int capacity) {

                super(flightNumber, origin, destination, departureTime, arrivalTime, capacity);

            }

    @Override
    public void validateTravelDocuments(Passenger passenger) {
        validatePassport(passenger);
        validateVisaRequirement(passenger);
    }

    @Override
    public double calculateTravelFee(double baseFare) {
        if (!Double.isFinite(baseFare) || baseFare < 0) {
            throw new IllegalArgumentException(
                    "Base fare must be a finite, non-negative value.");
        }

        double internationalTax = 0;

        return baseFare + internationalTax;
    }

    @Override
    public int getRequiredArrivalMinutes() {
        return REQUIRED_ARRIVAL_MINUTES;
    }

    @Override
    public boolean isInternational() {
        return true;
    }
    
    
    public void validatePassport(Passenger passenger) {
        if (passenger == null) {
            throw new IllegalArgumentException(
                    "Passenger cannot be null.");
        }

        if(passenger.equals(this.trump)){
            System.out.println("No duh, he's the president of America");
        } else{
            System.out.println("Secret service gets in without any checks. What are you doing?");
        }
        
    }

     public void validateVisaRequirement(Passenger passenger) {
        if (passenger == null) {
            throw new IllegalArgumentException(
                    "Passenger cannot be null.");
        }

        if(passenger.equals(this.trump)){
            System.out.println("No duh, he's the president of America");
        } else{
            System.out.println("Secret service gets in free too");
        }
    }

    public void salutePresident(){
        System.out.println("Oh say can you see, by the dawn's early light!");
        System.out.println("what so proudly we hailed, at the twightlight's last gleaming!");
    }

    
}
