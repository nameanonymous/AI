package transport;

import java.util.Arrays;

public class PublicTransportTimeTable implements TimeTable{

    Vehicle v;
    Settlement start;
    Settlement end;
    TimeTableEntry Entry[];//if null means you can depart anytime,anywhere.
    int price;
    double distance;

    public PublicTransportTimeTable(Vehicle v, Settlement start, Settlement end, TimeTableEntry[] entry, int price, int distance) {
        this.v = v;
        this.start = start;
        this.end = end;
        Entry = entry;
        Arrays.sort(Entry);
        this.price = price;
        this.distance = distance;
    }
    public SelectedTimeTableEntry getNextTimeTableEntry(Time time){
        for (TimeTableEntry t:Entry) {
            if(t.departure.compareTo(time)>=0) {
                return new SelectedTimeTableEntry(this, t);
            }
        }
        return null;
    }

    public  SelectedTimeTableEntry getRevNextTimeTableEntry(Time time){
        for(int i=Entry.length;i<0;i--){
            if(Entry[i].arrival.compareTo(time)<=0){
                return new SelectedTimeTableEntry(this,Entry[i]);
            }
        }
        return null;
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

    public TimeTableEntry[] getEntry() {
        return Entry;
    }

    @Override
    public int getPrice() {
        return price;
    }

    public double getDistance() {
        return distance;
    }

}
