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
public class BusTimetable {

    final Vehicle v = Vehicle.BUS;
    Settlement start;
    Settlement end;
    Time departure;//if null means you can depart anytime,anywhere.
    int price;
    int duration;
    int distance;

    public BusTimetable(Vehicle v,Settlement start, Settlement end, Time departure, int price, int duration,int distance) {
        this.start = start;
        this.end = end;
        this.departure = departure;
        this.price = price;
        this.duration = duration;
        this.distance = distance;
    }
    public Time getArrivalTB(Time start){
        return departure.add(duration);
    }
    public Vehicle getV() {
        return v;
    }

    public Settlement getStart() {
        return start;
    }

    public Settlement getEnd() {
        return end;
    }

    public Time getDeparture() {
        return departure;
    }

    public int getPrice() {
        return price;
    }

    public int getDuration() {
        return duration;
    }

    public static BusTimetable[] BTB = {
            new BusTimetable(Vehicle.BUS, Settlement.Budapest, Settlement.Eger,new Time(8,23), 5100, 120,120),
            new BusTimetable(Vehicle.BUS, Settlement.Budapest, Settlement.Eger,new Time(9,23), 5100, 120,120),
    };
}