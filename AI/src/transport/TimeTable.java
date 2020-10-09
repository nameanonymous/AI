package transport;

public class TimeTable {

    Settlement start;

    Settlement end;

    Time timeToStart; // if null then anything

    // other properties

    int price;

    int duration;

    int distance;

    Vehicle vehicle;

    public TimeTable(Vehicle vehicle, Settlement start, Settlement end, Time timeToStart, int price, int duration, int distance) {
        this.vehicle = vehicle;
        this.start = start;
        this.end = end;
        this.timeToStart = timeToStart;
        this.price = price;
        this.duration = duration;
        this.distance = distance;
    }

    public Time getArrivalTime(Time start) {
        if (timeToStart == null) {
            return start.add(duration);
        } else {
            return timeToStart.add(duration);
        }
    }

    public static TimeTable[] ENRIES = {

//            new TimeTableEntry(Vehicle.TRAIN, Settlement.Budapest, Settlement.Debrecen, new Time(6,23), 5100, 150, 220 ),
//            new TimeTableEntry(Vehicle.TRAIN, Settlement.Budapest, Settlement.Debrecen, new Time(7,23), 5100, 150, 220 ),
//            new TimeTableEntry(Vehicle.TRAIN, Settlement.Budapest, Settlement.Debrecen, new Time(8,23), 5100, 150, 220 ),
//            new TimeTableEntry(Vehicle.TRAIN, Settlement.Budapest, Settlement.Eger, new Time(8,00), 3000, 150, 120 ),
//            new TimeTableEntry(Vehicle.BUS, Settlement.Budapest, Settlement.Eger, new Time(8,23), 5100, 120, 220 ),
//            new TimeTableEntry(Vehicle.CAR, Settlement.Budapest, Settlement.Debrecen, null,7000, 120 , 220 ),

    };

    public Time getTimeToStart(Time now) {
        return timeToStart == null ? now : timeToStart;
    }

    public Settlement getStart() {
        return start;
    }

    public Settlement getEnd() {
        return end;
    }
}
