package transport;

public class CarTimetable implements TimeTable  {
    Vehicle v = Vehicle.CAR;
    Settlement start;
    Settlement end;
    int price;
    int distance;
    int duration;

    public CarTimetable(Settlement start, Settlement end, int price, int distance, int duration) {
        this.start = start;
        this.end = end;
        this.price = price;
        this.distance = distance;
        this.duration = duration;
    }

    @Override
    public Vehicle getV() {
        return v;
    }

    @Override
    public Settlement getStart() {
        return start;
    }

    @Override
    public Settlement getEnd() {
        return end;
    }

    @Override
    public SelectedTimeTableEntry getNextTimeTableEntry(Time time) { return new SelectedTimeTableEntry(this,new TimeTableEntry(time,time.add(duration))); }
    @Override
    public int getPrice() {
        return price;
    }

    public double getDistance() {
        return distance;
    }

    public int getDuration() {
        return duration;
    }
}
