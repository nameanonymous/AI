/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transport;

/**
 *
 * @author Masaya Misaizu
 */
public class TrainTimetable {

    final Vehicle v  = Vehicle.TRAIN;
    Settlement start;
    Settlement end;
    Time departure;//if null means you can depart anytime,anywhere.
    int price;
    int duration;
    int distance;

    public TrainTimetable(Vehicle v, Settlement start, Settlement end, Time departure, int price, int duration,int distance) {
        this.start = start;
        this.end = end;
        this.departure = departure;
        this.price = price;
        this.duration = duration;
        this.distance = distance;
    }

    public Time getArrivalTT(Time start){
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

    public static TrainTimetable[] TTB = {
            new TrainTimetable(Vehicle.TRAIN, Settlement.Budapest, Settlement.Debrecen, new Time(6,23), 5100, 150 ,220),
            new TrainTimetable(Vehicle.TRAIN, Settlement.Budapest, Settlement.Debrecen, new Time(7,23), 5100, 150 ,220),
            new TrainTimetable(Vehicle.TRAIN, Settlement.Budapest, Settlement.Debrecen, new Time(8,23), 5100, 150 ,220),
            new TrainTimetable(Vehicle.TRAIN, Settlement.Budapest, Settlement.Eger, new Time(8,00), 3000, 150 ,220)
    };

}


