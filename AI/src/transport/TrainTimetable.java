/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transport;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Masaya Misaizu
 */
public class TrainTimetable implements TimeTable {

    final Vehicle v  = Vehicle.TRAIN;
    Settlement start;
    Settlement end;
    TimeTableEntry Entry[];//if null means you can depart anytime,anywhere.
    int price;
    int distance;

    public TrainTimetable(Settlement start, Settlement end, TimeTableEntry[] entryT, int price, int distance) {
        this.start = start;
        this.end = end;
        Entry = entryT;
        this.price = price;
        this.distance = distance;
    }
    public SelectedTimeTableEntry getNextTimeTableEntry(Time time){
        for (TimeTableEntry t:Entry) {
            if(t.departure.compareTo(time)>=0){
                return new SelectedTimeTableEntry(this,t);
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

    public int getDistance() {
        return distance;
    }
}


