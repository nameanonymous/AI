package transport;

public class TimeTableEntry implements Comparable<TimeTableEntry>{
    @Override
    public String toString() {
        return "TimeTableEntry{" +
                "departure=" + departure +
                ", arrival=" + arrival +
                '}';
    }

    @Override
    public int compareTo(TimeTableEntry timeTableEntry) {
        return departure.compareTo(timeTableEntry.departure);
    }

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
