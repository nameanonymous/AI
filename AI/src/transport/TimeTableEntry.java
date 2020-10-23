package transport;

public class TimeTableEntry {

    Time departure;
    Time arrival;

    public Time getDeparture() {
        return departure;
    }

    public Time getArrival() {
        return arrival;
    }

    public TimeTableEntry(Time departure, Time arrival) {
        this.departure = departure;
        this.arrival = arrival;
    }
}
