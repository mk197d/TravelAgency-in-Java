package com.mayank8197d.nymble;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class EnrollPassengerTest {
    @Test

    public void check_if_passenger_enrolled() {
        final PackageInterface add_passenger = new AddPassenger();
        final PackageInterface add_activity = new AddActivity();
        final PackageInterface add_destination = new AddDestination();
        final PackageInterface enroll_passenger = new EnrollPassenger();

        Package travelPackage = new Package("package1", 10);
        add_passenger.add_passenger(travelPackage, "person1", 1, "Gold", 1000);
        add_passenger.add_passenger(travelPackage, "person2", 2, "Standard", 550);
        

        add_destination.add_Destination(travelPackage, "destination1");
        add_activity.add_Activity(travelPackage, "activity1", 001, "This is first activity", "destination1", 100, 2);

        enroll_passenger.enroll_passanger(travelPackage, "person1", 1, "activity1", 001);
        enroll_passenger.enroll_passanger(travelPackage, "person2", 2, "activity1", 001);

        Activity act = travelPackage.get_itinerary().get(0).get_Activities().get(0);
        assertTrue(act.get_passengers().get(0).get_name() == "person1");
        assertTrue(act.get_passengers().get(1).get_name() == "person2");
    }
}