/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transport;

/**
 *
 * @author Masaya Misaizu
// */
public class BusTimetable implements TimeTable {

    final Vehicle v = Vehicle.BUS;
    Settlement start;
    Settlement end;
    TimeTableEntry Entry[];//if null means you can depart anytime,anywhere.
    int price;
    int distance;

    public BusTimetable(Settlement start, Settlement end, TimeTableEntry[] entry, int price, int distance) {
        this.start = start;
        this.end = end;
        Entry = entry;
        this.price = price;
        this.distance = distance;
    }
    public TimeTableEntry getNextTimeTableEntry(Time time){
        for (TimeTableEntry t:Entry) {
            if(t.departure.compareTo(time)>=0){
                return t;
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

    public int getDistance() {
        return distance;
    }
}